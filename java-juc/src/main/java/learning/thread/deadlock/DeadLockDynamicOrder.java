package learning.thread.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 这个其实和DeadLockOrder类似
 */
public class DeadLockDynamicOrder {
    private int count = 0;

    public int add(Object obj, Object lock) {
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
}
