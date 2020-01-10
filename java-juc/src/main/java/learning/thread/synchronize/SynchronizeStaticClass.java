package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 是顺序运行的，加锁了
 */
public class SynchronizeStaticClass {
    private static int i = 0;
    public static int add() {
        synchronized (SynchronizeStaticClass.class) {//这里不能用this，会报错
            for (int j = 0; j < 10; j++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);//让其他线程有进入的机会
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 当前i：" + i);
            }
        }
        return i;
    }
}
