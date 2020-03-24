package com.learning.zookeeper.api.client;

import com.learning.zookeeper.api.config.ZkConfig;
import com.learning.zookeeper.api.watcher.DefaultWatcher;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

//zk是有session概念的，没有连接池的概念
//watch:观察，回调
//watch的注册值发生在 读类型调用，get，exites。。。
//第一类：new zk 时候，传入的watch，这个watch，session级别的，跟path 、node没有关系。

@Component
public class ZkClient {
    @Autowired
    private ZkConfig zkConfig;

    public void runZK() throws Exception {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        ZooKeeper zk = new ZooKeeper(zkConfig.getUrl(), zkConfig.getTimeOut(), new DefaultWatcher(countDownLatch));

        countDownLatch.await();

        ZooKeeper.States state = zk.getState();
        switch (state) {
            case CONNECTING:
                System.out.println("正在连接中。。。。。。");
                break;
            case ASSOCIATING:
                break;
            case CONNECTED:
                System.out.println("连接成功。。。。。");
                break;
            case CONNECTEDREADONLY:
                break;
            case CLOSED:
                break;
            case AUTH_FAILED:
                break;
            case NOT_CONNECTED:
                break;
        }

        String pathName = zk.create("/learning", "学习分支".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

        System.out.println("创建的pathName是：" + pathName);

        System.out.println("第一次获取值开始=======");
        byte[] data = zk.getData("/learning", new Watcher() {// 当该path被更新的时候就会调用该watcher
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("第一次获取值watcher：" + watchedEvent);
                System.out.println("第一次获取值watcher path：" + watchedEvent.getPath());
                System.out.println("第一次获取值watcher type：" + watchedEvent.getType());
                System.out.println("第一次获取值watcher state：" + watchedEvent.getState());
                try {
                    zk.getData("/learning", true, new Stat());//此时调用的是session的watcher，也就是defaultWatcher
                } catch (KeeperException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, new Stat());
        System.out.println("结果是：" + (new String(data)));
        System.out.println("第一次获取值结束=======\n");

        System.out.println("第一次更新开始================");
        Stat firstStat = zk.setData("/learning", "更新的值".getBytes(), 0);
        System.out.println("第一次更新的后的版本：" + firstStat.getVersion());
        System.out.println("第一次更新完成================\n");

        System.out.println("第二次更新开始================");
        final Stat secondStat = new Stat();
        //此时会调用defaultWatcher
        zk.setData("/learning", "第二次更新值".getBytes(), firstStat.getVersion(), new AsyncCallback.StatCallback() {
            @Override
            public void processResult(int i, String s, Object o, Stat stat) {
                System.out.println("第二次更新设置的回调函数开始==========");
                System.out.println("参数是：" + ((String) o));
                System.out.println("i：" + i);
                System.out.println("第二次更新操作：" + s);
                System.out.println("第二次更新操作：" + stat);
                System.out.println("第二次更新操作版本：" + stat.getVersion());
                secondStat.setVersion(stat.getVersion());
                System.out.println("第二次更新设置的回调函数结束==========\n");
            }
        }, "第二次更新传入的参数");
        System.out.println("第二次更新完成================\n");

        Thread.sleep(2000);

        System.out.println("第三次更新开始================");
        Stat thirdStat = zk.setData("/learning", "第三次更新的值".getBytes(), firstStat.getVersion() + 1);
        System.out.println("第三次更新完成================\n");


        System.out.println("第二次次获取值开始=======");
        zk.getData("/name", new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                System.out.println("第二次获取值watcher：" + watchedEvent);
                System.out.println("第二次获取值watcher path：" + watchedEvent.getPath());
                System.out.println("第二次获取值watcher type：" + watchedEvent.getType());
                System.out.println("第二次获取值watcher state：" + watchedEvent.getState());
            }
        }, new AsyncCallback.DataCallback() {//当有值更新的时候会调用该回调方法，会先于watcher调用
            @Override
            public void processResult(int i, String s, Object o, byte[] bytes, Stat stat) {
                System.out.println("第四次更新设置的回调函数开始==========");
                System.out.println("参数是：" + ((String) o));
                System.out.println("i：" + i);
                System.out.println("第四次更新操作：" + s);
                System.out.println("第四次更新操作：" + stat);
                System.out.println("第四次更新操作版本：" + stat.getVersion());
                System.out.println("第四次更新设置的回调函数结束==========\n");
            }
        }, "第二次传参");
        System.out.println("第二次次获取值结束=======\n");

        System.out.println("第四次更新开始================");
        Stat forthStat = zk.setData("/learning", "第四次更新的值".getBytes(), thirdStat.getVersion());
        System.out.println("第四次更新的后的版本：" + forthStat.getVersion());
        System.out.println("第四次更新完成================\n");

        System.out.println("程序执行完毕");
//        zk.close();
    }
}
