package learning.thread.concurrent.locks;

import learning.util.TimeUtil;

import java.util.concurrent.locks.LockSupport;

/**
 * 1. LockSupport 不需要synchronized加锁就可以实现线程的阻塞和唤醒
 * 2. 如果一个线程处于等待状态，连续调用了两次park()，就会使线程永远无法唤醒
 */
public class LockSupportExample {
    public void testLockSupport() {
        Thread t = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if(i == 5) {
                    LockSupport.park(); //为线程调度的目的禁用当前线程，除非许可证可用。
                }

//                if (i == 8) {
//                    LockSupport.park();
//                }
                TimeUtil.timeSleep(1);
            }
        });

        t.start();


        TimeUtil.timeSleep(10);
        LockSupport.unpark(t); // 提供给定线程的可用的许可证(如果它还没有可用)。
    }
}
