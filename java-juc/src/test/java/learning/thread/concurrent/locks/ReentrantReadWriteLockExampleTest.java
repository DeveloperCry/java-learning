package learning.thread.concurrent.locks;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReentrantReadWriteLockExampleTest {
    public static void main(String[] args) {
        ReentrantReadWriteLockExample example = new ReentrantReadWriteLockExample();
        ExecutorService readService = Executors.newCachedThreadPool();
        ExecutorService writeService = Executors.newCachedThreadPool();

        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 30; i++) {
            readService.submit(()->{
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                example.display();
            });
        }

        for (int i = 0; i < 2; i++) {
            writeService.submit(()-> {
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                example.add(String.valueOf(new Random().nextInt()));
            });
        }

        System.out.println("开始测试");
        countDownLatch.countDown();
        readService.shutdown();
        writeService.shutdown();

    }
}
