package learning.thread.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 加锁的顺序错误导致的死锁
 */
public class DeadLockOrder {
    private int count = 0;
    private final Object obj = new Object();
    private final Object lock = new Object();

    public int add() {
        System.out.println(Thread.currentThread().getName() + "开始");
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + "获得锁obj");
            try {
                //为的是能够让第二个线程获得lock这把锁，这样才能形成死锁
                TimeUnit.MILLISECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + "获得锁lock");
                for (int i = 0; i < 10; i++) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
                }
            }

        }
        return count;
    }

    public int add2() {
        System.out.println(Thread.currentThread().getName() + "开始");
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + "获得锁lock");
            synchronized (obj) {
                System.out.println(Thread.currentThread().getName() + "获得锁obj");
                for (int i = 0; i < 5; i++) {
                    count++;
                    System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
                }
            }
        }

        return count;
    }
}
