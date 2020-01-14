package learning.thread.deadlock;

import java.util.concurrent.TimeUnit;

public class DeadLockInvokeTest {
    public static void main(String[] args) throws InterruptedException {
        DeadLockInvoke invoke1 = new DeadLockInvoke();
        DeadLockInvoke invoke2 = new DeadLockInvoke();
        new Thread(() -> invoke1.minus(invoke2), "减法线程").start();

        TimeUnit.MILLISECONDS.sleep(1000);
        new Thread(() -> invoke2.add(invoke1), "加法线程").start();
    }
}
