package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 这个类是为了同步和非同步方法同时调用
 *
 * 在这个程序中，可以看到同步线程是顺序执行的，但是非同步现在就是在“乱跑”，
 *
 */
public class SynchronizeMixture {
    private int i = 0;
    public synchronized int synchronizedAdd() {//这里相当于synchronized(this)
        System.out.println(Thread.currentThread().getName() + " start");
        for (int j = 0; j < 10; j++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);//让其他线程有进入的机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前i：" + i);
        }
        System.out.println(Thread.currentThread().getName() + " end");
        return i;
    }

    public int noSynchronizedAdd() {
        System.out.println(Thread.currentThread().getName() + " start");
        for (int j = 0; j < 10; j++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);//让其他线程有进入的机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前i：" + i);
        }
        System.out.println(Thread.currentThread().getName() + " end");
        return i;
    }
}
