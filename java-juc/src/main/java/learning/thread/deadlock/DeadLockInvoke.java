package learning.thread.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 这个是对象调用的时候错误导致的死锁
 *
 * 流程大概是这样的(有点绕)：
 * 当调用add方法的时候，它必须先调用另外一个对象对象的减方法；当调用减方法的时候必须先调用另外一个对象的加方法。
 * 1. 在调用方有两个对象，当第一个线程第一个对象在调用减方法的时候，将会调用第二个对象的加方法，这个时候就会对第一个对象减方法和第二对象的加方法加锁
 * 2. 当第二个线程调用第二个对象在调用加方法的时候，将会调用第一个对象的减方法，这个时候就会对第一个对象减方法和第二对象的加方法加锁
 * 3. 当第一个线程调用第二对象的加方法时，发现有锁了，就等待
 * 4. 但是，当第二个线程调用第一个对象的减方法的时候，发现也有锁了，就等待
 * 5. 最后，两个线程都没有释放锁
 */
public class DeadLockInvoke {
    private int count = 0;

    public synchronized void add(DeadLockInvoke invoke) {
        System.out.println(Thread.currentThread().getName() + "开始");

        try {
            TimeUnit.MILLISECONDS.sleep(2000);//为了看清过程，所以时间设置大点
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "开始调用另外对象的减方法");
        invoke.minus(this);//等待获取锁
        count ++;
        System.out.println(Thread.currentThread().getName() + "结束");
    }

    public synchronized void minus(DeadLockInvoke invoke) {
        System.out.println(Thread.currentThread().getName() + "开始");
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "开始调用另外对象的加方法");
        invoke.add(this);//等待获取锁
        count --;
        System.out.println(Thread.currentThread().getName() + "结束");
    }
}
