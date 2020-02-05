package learning.thread.concurrent.atomics;

import learning.constant.Constants;
import learning.entity.User;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class AtomicTest {

    public static void main(String[] args) throws InterruptedException {
        Atomic atomic = new Atomic();
        User user = new User(20);
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(Constants.TOTAL_THREAD);
        CountDownLatch countDownLatch = new CountDownLatch(Constants.TOTAL_REQUEST);
        for (int i = 0; i < Constants.TOTAL_REQUEST; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    atomic.addAtomicInteger();
                    atomic.addLongAdder();
                    atomic.addInt();
                    atomic.addAtomicLong();
                    atomic.atomicReference();
                    atomic.atomicIntegerFieldUpdater(user);
                    atomic.longAccumulator();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("AtomicInteger当前值是：" + atomic.getAtomicInteger().get());
        System.out.println("AtomicLong当前值是：" + atomic.getAtomicLong().get());
        System.out.println("Int当前值是：" + atomic.getI());
        System.out.println("LongAdder当前值是：" + atomic.getLongAdder());
        System.out.println("AtomicReference当前值是：" + atomic.getAtomicReference());
        System.out.println("AtomicIntegerFieldUpdater当前值是：" + atomic.getUpdater().get(user));
        System.out.println("LongAccumulator当前值是：" + atomic.getLongAccumulator().get());

    }
}
