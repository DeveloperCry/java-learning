package learning.thread.volatiles;

import learning.constant.Constants;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class VolatileActionTest {
    public static void main(String[] args) throws InterruptedException {
        VolatileAction action = new VolatileAction();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(Constants.TOTAL_THREAD);
        CountDownLatch countDownLatch = new CountDownLatch(Constants.TOTAL_REQUEST);
        for (int i = 0; i < Constants.TOTAL_REQUEST; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    action.addCount();
                    action.addVolCount();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("Count当前值是：" + action.getCount());
        System.out.println("Volatile Count当前值是：" + action.getVolCount());

    }
}
