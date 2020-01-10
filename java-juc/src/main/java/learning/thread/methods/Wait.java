package learning.thread.methods;

import java.util.concurrent.TimeUnit;

public class Wait {
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
                    t1.notify();
                }
            }
        });

        t1.start();
        try {
            t1.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}
