package learning.thread.methods;

import java.util.concurrent.TimeUnit;

public class WaitTest {
    public static void main(String[] args) throws InterruptedException {
        Wait wait = new Wait();
        Thread t1 = new Thread(() -> {
            try {
                wait.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1");

        Thread t2 = new Thread(() -> {
            try {
                wait.add2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程2");

        t1.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        t2.start();
    }
}
