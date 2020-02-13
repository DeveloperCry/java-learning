package learning.thread.concurrent.locks;

import learning.util.TimeUtil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock用于替代synchronized
 * 由于m1锁定this,只有m1执行完毕的时候,m2才能执行
 * 这里是复习synchronized最原始的语义
 *
 * 使用reentrantlock可以完成同样的功能
 * 需要注意的是，必须要必须要必须要手动释放锁（重要的事情说三遍）
 * 使用syn锁定的话如果遇到异常，jvm会自动释放锁，但是lock必须手动释放锁，因此经常在finally中进行锁的释放
 *
 * 使用reentrantlock可以进行“尝试锁定”tryLock，这样无法锁定，或者在指定时间内无法锁定，线程可以决定是否继续等待
 *
 * 使用ReentrantLock还可以调用lockInterruptibly方法，可以对线程interrupt方法做出响应，
 * 在一个线程等待锁的过程中，可以被打断
 *
 * ReentrantLock还可以指定为公平锁，默认的是非公平锁
 *
 * 3个特有的功能，当需要用到一下三个独有的功能的时候可以用ReentrantLock，其余的情况还是考虑用Synchronized：
 *    1. 等待可中断：持有锁的线程长期不释放的时候，正在等待的线程可以选择放弃等待，这相当于Synchronized来说可以避免出现死锁的情况。通过lock.lockInterruptibly()来实现这个机制。
 *    2. 公平锁： 多个线程等待同一个锁时，必须按照申请锁的时间顺序获得锁，Synchronized锁非公平锁，ReentrantLock默认的构造函数是创建的非公平锁，可以通过参数true设为公平锁，但公平锁表现的性能不是很好。
 *    3. 锁绑定多个条件： 一个ReentrantLock对象可以同时绑定对个对象。ReenTrantLock提供了一个Condition（条件）类，用来实现分组唤醒需要唤醒的线程们，而不是像synchronized要么随机唤醒一个线程要么唤醒全部线程。
 *        条件的例子：假设我们有一个有界的缓冲区，它支持put和take方法。如果尝试在空缓冲区上执行take操作，则线程将阻塞，直到某个项可用为止;如果在一个完整的缓冲区上尝试put，那么线程将阻塞，直到空间可用为止。
 *                   我们希望将put线程和take线程放在不同的等待集中，这样我们就可以优化在缓冲区中的项或空间可用时只通知单个线程。这可以通过使用两个条件实例来实现。
 */
@Getter
public class ReentrantLockExample {
    private final static ReentrantLock lock = new ReentrantLock();
    private final static ReentrantLock interruptLock = new ReentrantLock();
    private final static ReentrantLock fairLock = new ReentrantLock(true);
    private final static ReentrantLock conditionLock = new ReentrantLock();
    private final static Condition notFull = conditionLock.newCondition();
    private final static Condition notEmpty = conditionLock.newCondition();

    private int count = 0;
    private int commonCount = 0;
    private List<String> list = Collections.synchronizedList(new ArrayList<>());
    private int size = 3;

    public void add() {
        try {
            lock.lock();
            count++;
//            System.out.println(Thread.currentThread().getName() + "：" + ", 当前count：" + count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void addCommon() {
        commonCount ++;
    }

    public void testFairLock() {
        new Thread(() -> {
            for(int i=0; i<5; i++) {
                TimeUtil.timeSleep(2);
                fairLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+"：获得锁");
                }finally{
                    fairLock.unlock();
                }
            }
        }).start();
        new Thread(() -> {
            for(int i=0; i<5; i++) {
                fairLock.lock();
                try{
                    System.out.println(Thread.currentThread().getName()+"：获得锁");
                }finally{
                    fairLock.unlock();
                }
            }
        }).start();
    }

    public void testInterruptLock() {
        new Thread(() -> {
            try{

                interruptLock.lock();
                TimeUtil.timeSleep(Integer.MAX_VALUE);
                System.out.println("这是一个正常的线程");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                interruptLock.unlock();
            }
        }).start();
        TimeUtil.timeSleep(1);
        Thread thread = new Thread(() -> {
            try{

//                interruptLock.lock();
                interruptLock.lockInterruptibly(); //除非当前线程中断，否则获取锁。可以对interrupt()方法做出响应
                System.out.println("打断线程获得锁");
                TimeUtil.timeSleep(4);
                System.out.println("打断线程结束");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                interruptLock.unlock();
            }
        });

        thread.start();
        TimeUtil.timeSleep(8);
        System.out.println("开始打断");
        thread.interrupt();
    }

    public void testCondition() {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    TimeUtil.timeSleep(1);
                    put(String.valueOf(new Random().nextInt()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

//        TimeUtil.timeSleep(1);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    TimeUtil.timeSleep(1);
                    take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void put(String str) throws InterruptedException {
        conditionLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":插入获取锁====" + list.size());
            while (list.size() >= size) {
                System.out.println(Thread.currentThread().getName() + ":插入锁等待");
                notFull.await();
            }
            list.add(str);
            System.out.println(Thread.currentThread().getName() + ":添加成功：" + str);
            notEmpty.signal();
        } finally {
            conditionLock.unlock();
        }
    }

    public void take() throws InterruptedException {
        conditionLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + ":读取获取锁====");
            while (list.size() == 0) {
                System.out.println(Thread.currentThread().getName() + ":当前没有数据");
                notEmpty.await();
            }
            System.out.println(Thread.currentThread().getName() + ":当前list的个数是：" + list.size());
            list.remove(list.size() - 1);
            notFull.signal();
        } finally {
            conditionLock.unlock();
        }
    }
}
