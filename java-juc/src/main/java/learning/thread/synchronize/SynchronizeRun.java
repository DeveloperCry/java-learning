package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 这个程序需要注意的是volatile没有锁的功能，它只是让变量具有可见性和防止指令重排序
 */
public class SynchronizeRun implements Runnable{
    private /*volatile*/ int count = 0;

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);//让其他线程有进入的机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
        }
    }
}
