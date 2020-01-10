package learning.thread.methods;

import java.util.concurrent.TimeUnit;

public class WaitAfterWakeUpTest {
    public static void main(String[] args) throws InterruptedException {
        WaitAfterWakeUp wait = new WaitAfterWakeUp();
        new Thread(() -> {
            try {
                wait.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "等待线程").start();

        for (int i = 0; i < 500; i++) {
            new Thread(() -> wait.add2(), "线程" + i).start();
        }
    }
}
