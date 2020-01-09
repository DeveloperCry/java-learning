package learning.thread.methods;

import java.util.concurrent.TimeUnit;

/**
 * Yield 是指当当前的CUP让出一下，让其他线程有机会得到运行的机会
 * 让出一下CPU让其他线程有执行的机会，当它让出的时候，他会进入到就绪状态然后再等机会进入CPU中运行
 *
 */
public class Yield {
    public void yieldMethod() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i%2 == 0) {
                    Thread.yield();
                }
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 其状态是：" + Thread.currentThread().getState());
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 其状态是：" + Thread.currentThread().getState());
            }
        }).start();
    }
}
