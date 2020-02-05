package learning.thread.concurrent.locks.reentrantlock;

import learning.util.TimeUtil;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock1 {
    private final static ReentrantLock lock = new ReentrantLock();
    private int count = 0;

    public void add() {
        try {
            lock.lock();
            for (int j = 0; j < 10; j++) {
                TimeUnit.MILLISECONDS.sleep(1);
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + j + ", 当前count：" + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
