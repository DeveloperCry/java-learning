package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 在没有加锁的情况下是乱序运行的
 *
 * 运行结果可以看出结果不能每次达到1000
 */
public class NoSynchronize {
    private int i = 0;
    public int add() {
        for (int j = 0; j < 10; j++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);//让其他线程有进入的机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
            System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前i：" + i);
        }
        return i;
    }
}
