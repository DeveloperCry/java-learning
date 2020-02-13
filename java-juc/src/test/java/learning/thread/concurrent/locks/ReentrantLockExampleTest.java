package learning.thread.concurrent.locks;

import learning.constant.Constants;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ReentrantLockExampleTest {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(Constants.TOTAL_REQUEST);
        Semaphore semaphore = new Semaphore(Constants.TOTAL_THREAD);

        ReentrantLockExample lock = new ReentrantLockExample();
        for (int i = 0; i < Constants.TOTAL_REQUEST; i++) {
            service.submit(() -> {
                try {
                    semaphore.acquire();
//                    lock.add();
//                    lock.addCommon();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            });
        }

        countDownLatch.await();
        service.shutdown();
        System.out.println("Count结果是：" + lock.getCount());
        System.out.println("Common Count结果是：" + lock.getCommonCount());
//        lock.testInterruptLock();
//        lock.testFairLock();
        lock.testCondition();
    }
}
