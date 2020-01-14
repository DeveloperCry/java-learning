package learning.thread.methods;

import java.util.concurrent.TimeUnit;

public class NotifyALLTest {
    public static void main(String[] args) throws InterruptedException {
        NotifyAll notifyAll = new NotifyAll();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    notifyAll.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "等待线程 " + i).start();
        }

        Thread t2 = new Thread(() -> {
            try {
                notifyAll.add2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "唤醒线程 ");

        TimeUnit.MILLISECONDS.sleep(1000);
        t2.start();
    }
}
