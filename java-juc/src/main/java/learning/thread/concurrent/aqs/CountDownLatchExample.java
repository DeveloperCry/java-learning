package learning.thread.concurrent.aqs;

import learning.constant.Constants;
import learning.util.TimeUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 一种同步帮助，允许一个或多个线程等待，直到在其他线程中执行的一组操作完成。
 * 其实就是相当于一个栅栏，等到所有的线程都完成的时候，即当前计数器为0的时候，就开放栅栏往后年继续执行
 *
 * CountDownLatch是用给定的count初始化的。
 * 由于调用了countDown()方法，await方法阻塞，直到当前计数为零，之后释放所有等待线程，并立即返回任何后续的await调用。
 * 这是一种一次性现象——计数无法重置。如果需要重置计数的版本，可以考虑使用CyclicBarrier。
 *
 * CountDownLatch是一种通用的同步工具，可以用于多种用途。
 * count为1时初始化的CountDownLatch用作简单的on/off latch或gate:所有调用wait的线程都在gate处等待，直到调用countDown()的线程打开它。
 * 一个初始化为N的CountDownLatch可以用来让一个线程等待，直到N个线程完成某个动作，或者某个动作已经完成N次。
 *
 * CountDownLatch的一个有用的特性是，它不需要调用倒计时的线程等待计数达到零才继续，它只是防止任何线程继续等待，直到所有线程都通过。
 *
 * 这里还要注意wait和countDown()方法的调用顺序：
 *     如果wait在线程里面，那么线程里面的所有的在wait之后的程序将会出于等待状态，并且要在主线程完成countDown方法之后才会执行
 *     如果countDown在线程里面，那么主线程wait将会阻塞后续执行，直到countDownLatch减为0
 * 最后，wait方法和countdown方法不能同时出现在一个线程中(要么是主线程中一个，子线程中一个)
 */
public class CountDownLatchExample {
    private int count = 0;
    private volatile int sleepCount = 0;
    private int apiCount = 0;
    private volatile int countDown = 0;

    public void testWait() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(Constants.TOTAL_THREAD);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < Constants.TOTAL_THREAD; i++) {
            service.submit(() -> {
                count ++;
                countDownLatch.countDown();
            });
        }

        countDownLatch.await();
        service.shutdown();
        System.out.println("最终count的值为：" + count);
    }


    public void testCountDown() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < Constants.TOTAL_THREAD; i++) {
            service.execute(() -> {
                TimeUtil.timeSleep(2);
                countDown ++;
                countDownLatch.countDown();
                System.out.println("当前countDownLatch.getCount()：" + countDownLatch.getCount());
            });
        }

        countDownLatch.await();
        System.out.println("等待结束了");
        service.shutdown();
        System.out.println("最终countDown的值为：" + countDown);
    }


    /**
     * 导致当前线程等待，直到锁存器计数到零，除非线程被中断，或者指定的等待时间已过。
     * 就是等待一个固定的时间，等时间过了就不等了，就执行了
     * @throws InterruptedException
     */
    public void testWaitTime() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(Constants.TOTAL_THREAD);
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < Constants.TOTAL_THREAD; i++) {
            service.submit(() -> {
                sleepCount ++;
//                System.out.println("开始等待:" + sleepCount);
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("结束等待:" + sleepCount);
                countDownLatch.countDown();
            });
        }

        countDownLatch.await(4, TimeUnit.MILLISECONDS);
        service.shutdown();
        System.out.println("最终sleep count的值为：" + sleepCount);
    }

    public void testAPIExample() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(Constants.TOTAL_THREAD);

        for (int i = 0; i < Constants.TOTAL_THREAD; ++i) {// create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        System.out.println("开始信号");
        startSignal.countDown();      // let all threads proceed
        System.out.println("完成信号等待");
        doneSignal.await();           // wait for all to finish
        System.out.println("所有的线程结束");
    }

    class Worker implements Runnable {
        private final CountDownLatch startSignal;
        private final CountDownLatch doneSignal;
        Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }
        public void run() {
            try {
                startSignal.await();
                add();
                doneSignal.countDown();
            } catch (InterruptedException ex) {} // return;
        }

        void add() {
            apiCount ++;
            System.out.println("创建线程" + apiCount);
        }
    }
}
