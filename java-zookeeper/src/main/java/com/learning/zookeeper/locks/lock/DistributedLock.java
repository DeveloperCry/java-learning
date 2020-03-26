package com.learning.zookeeper.locks.lock;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;


/**
 * 锁实现的原理就是：当某个线程释放锁的时候，每个线程都去请求zookeeper，然后去抢锁，如果是数量非常的多，会给服务器造成压力，(其实这个时候就类似非公平锁)
 * 但是我们可以优化，类似公平锁，每个锁都会无watch它前面的一个锁，如果它前面的锁释放了，那么久只有它才去获取锁，而不是所有的都去获取锁
 */
public class DistributedLock implements Watcher, AsyncCallback.Create2Callback, AsyncCallback.Children2Callback {
    private static final String LOCK_PATH = "/lock";

    private CountDownLatch countDownLatch = new CountDownLatch(1);// 该变量不能是静态的，如果是静态的，因为这个是要在各自的线程中独自占有，静态的将实例化一份
    private ZooKeeper zooKeeper;
    private String threadName;
    private String pathName;

    public DistributedLock(ZooKeeper zooKeeper) {
        this.zooKeeper = zooKeeper;
    }

    private void createLock() {
//        try {
            // 这样写时有问题的，因为创建完了马上就去调用getData的话，这个时候其实都是有值了，同时如果将await写在getData后面的话，前一个已经被删除了，而后一个再去监听就永远都不会存在
            // 因此在开始创建的时候就应该使用callback
//            return this.zooKeeper.create(LOCK_PATH, null, ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);

//        } catch (KeeperException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        this.zooKeeper.create(LOCK_PATH, this.threadName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL, this, this.threadName);
//        return null;

    }

    public void lock() {
        try {
            this.createLock();
            //这里不能用getData方法，如果是这样，await将失效，应该是create的时候就应该出现callback
//            this.zooKeeper.getData(this.pathName, false, this, this.pathName);
            this.countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void unlock() {
        try {
            this.zooKeeper.delete(this.pathName, -1);
            System.out.println(this.threadName + "释放锁。。。。。。");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
    // Watcher
    @Override
    public void process(WatchedEvent event) {
//        System.out.println(event);
        //如果第一个等待的线程，那个锁释放了，其实只有第二个收到了回调事件！！
        //如果，不是第一个等待的线程，某一个，挂了，也能造成他后边的收到这个通知，从而让他后边那个跟去watch挂掉这个排队的线程前边的。。。
        if (Event.EventType.NodeDeleted.equals(event.getType())) {
            this.zooKeeper.getChildren("/", false, this, this.threadName);
        }
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    // create2 callback
    @Override
    public void processResult(int rc, String path, Object ctx, String name, Stat stat) {
        if (name != null) {
            System.out.println(ctx + "：创建锁：" + name);
            this.pathName = name;
            this.zooKeeper.getChildren("/", false, this, (String) ctx);
        }
    }

    // Child2 callback
    @Override
    public void processResult(int rc, String path, Object ctx, List<String> children, Stat stat) {
        try {
            if (!CollectionUtils.isEmpty(children)) {
                Collections.sort(children);
//                System.out.println(this.threadName + ":" + children);
                String currentPath = this.pathName.substring(1);
                int index = children.indexOf(currentPath);
                if (index == 0) {
                    System.out.println("当前抢到锁的线程是：" + this.threadName);
//                    this.zooKeeper.setData("/", this.threadName.getBytes(), -1);
                    this.countDownLatch.countDown();
                } else {
                    Stat exists = this.zooKeeper.exists("/" + children.get(index - 1), this);
                    if (exists == null) {// 判断它的前一位是否存在，如果不存在，说明锁已经被释放了，就不用再去注册监听器了
                        this.countDownLatch.countDown();
                    }
                }

            }
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
