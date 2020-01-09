package learning.thread.methods;

import java.util.concurrent.TimeUnit;

/**
 * 让另外的一个线程加入到本线程中执行，等到那个线程执行完成之后，再执行本线程
 */
public class Join {
    /**
     * 这里是自定义的两个线程
     * @param args
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 其状态是：" + Thread.currentThread().getState());
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 其状态是：" + Thread.currentThread().getState());
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (i == 3) {
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }

    /**
     * 供自定义线程和主线程测试使用
     * @return
     */
    public Thread getThread1() {
        return new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "：" + i + ", 其状态是：" + Thread.currentThread().getState());
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
