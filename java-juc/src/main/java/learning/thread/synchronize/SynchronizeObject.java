package learning.thread.synchronize;

import java.util.concurrent.TimeUnit;

/**
 * 是顺序运行的，加锁了
 */
public class SynchronizeObject {
    private int count = 0;
    private final Object object = new Object();//如果想让它锁住的是同一个对象，就得不让其改变，加final，这个与锁的原理有关，也可以在class结构中可以看见
    public int add() {
        synchronized (object) {//任何线程要执行下面的代码，必须先拿到o的锁
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
