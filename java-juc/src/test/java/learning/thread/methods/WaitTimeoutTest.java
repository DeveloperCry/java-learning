package learning.thread.methods;

import java.util.concurrent.TimeUnit;

public class WaitTimeoutTest {
    public static void main(String[] args) throws InterruptedException {
        WaitTimeout wait = new WaitTimeout();
        Thread t1 = new Thread(() -> {
            try {
                wait.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "线程1");

        Thread t2 = new Thread(() -> wait.add2(), "线程2");

        t1.start();
        TimeUnit.MILLISECONDS.sleep(1000);
        t2.start();
    }
}
