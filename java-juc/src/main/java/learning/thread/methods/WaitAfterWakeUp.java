package learning.thread.methods;

import java.util.concurrent.TimeUnit;

/**
 * wait就是将线程设置为等待状态并让出锁和CPU，知道得到通知或者是等待的时间结束了再运行
 *
 * 这是一个当等待到时间的时候自动释放后，看是否需要与其他线程竞争
 *
 * 结论，当被唤醒的时候，需要重新与其他线程竞争
 *
 */
public class WaitAfterWakeUp {

    private int count = 0;
    private final Object obj = new Object();

    public int add() throws InterruptedException {
        synchronized (obj) {
            for (int i = 0; i < 10; i++) {
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
                if (i == 5) {
                    System.out.println(Thread.currentThread().getName() + "开始");
                    obj.wait(10);//这里的意思就是最长等待4s
                    System.out.println(Thread.currentThread().getName() + "等待结束");
                }
            }
        }
        return count;
    }

    public int add2() {
        synchronized (obj) {
            for (int i = 0; i < 5; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前count：" + count);
            }
        }

        return count;
    }
}
