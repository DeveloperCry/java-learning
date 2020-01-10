package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 程序在执行过程中，如果出现异常，默认情况锁会被释放
 * 所以，在并发处理的过程中，有异常要多加小心，不然可能会发生不一致的情况。
 * 在第一个线程中抛出异常，其他线程就会进入同步代码区，有可能会访问到异常产生时的数据。
 * 因此要非常小心的处理同步业务逻辑中的异常
 *
 * 这个就要看业务了，如下代码，当抛出异常的时候，第一个线程结束，并释放锁，第二个线程开始运行
 */
public class SynchronizeException {
    private int count = 0;
    public synchronized int add() {//这里相当于synchronized(this)
        for (int j = 0; j < 50; j++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);//让其他线程有进入的机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName() + "：" + j + ", 当前i：" + count);
            if (count == 30) {
                System.out.println(count /0);
            }
        }
        return count;
    }
}
