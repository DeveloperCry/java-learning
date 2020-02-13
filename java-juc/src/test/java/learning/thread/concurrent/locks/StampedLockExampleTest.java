package learning.thread.concurrent.locks;

import learning.constant.Constants;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class StampedLockExampleTest {
    public static void main(String[] args) throws Exception {
        StampedLockExample example = new StampedLockExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(Constants.TOTAL_THREAD);
        final CountDownLatch countDownLatch = new CountDownLatch(Constants.TOTAL_REQUEST);
        for (int i = 0; i < Constants.TOTAL_REQUEST ; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    example.add();
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count最后的值是：" + example.getCount());
    }
}
