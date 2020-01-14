package learning.thread.methods;

import java.util.concurrent.TimeUnit;

public class NotifyTest {
    public static void main(String[] args) throws InterruptedException {
        Notify notify = new Notify();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    notify.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "等待线程" + i).start();
        }

        Thread t2 = new Thread(() -> {
            try {
                notify.add2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "唤醒线程");

        TimeUnit.MILLISECONDS.sleep(1000);
        t2.start();
    }
}
