package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 是顺序运行的，加锁了
 */
public class SynchronizeClass {
    private int count = 0;
    public int add() {
        synchronized (SynchronizeClass.class) {//任何线程要执行下面的代码，必须先拿到this的锁，就是本身
            for (int j = 0; j < 10; j++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);//让其他线程有进入的机会
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
                System.out.println(Thread.currentThread().getName() + "：" + j + ", 当前count：" + count);
            }
        }
        return count;
    }
}
