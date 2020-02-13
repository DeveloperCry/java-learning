package learning.thread.concurrent.aqs;

import learning.util.TimeUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 计数信号量。从概念上讲，信号量维护一组许可证。如果需要，每个acquire()都会阻塞，直到获得许可证，然后获取许可证。
 * 每个release()添加一个许可证，潜在地释放一个阻塞的获取者。
 * 但是，没有实际使用许可证对象;信号量只是保持可用数量的一个计数，并相应地进行操作。
 *
 * 通俗的理解就是：Semaphore会初始化一个总的许可证个数，当每次访问之前，都将去获取许可证，如果获取到许可证，就继续执行，如果失败，就先等待
 */
public class SemaphoreExample {
    private int count = 0;
    private int tryCount = 0;


    public void testSemaphore() {
        ExecutorService service = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < 100; i++) {
            service.submit(() -> {
                try {
//                    semaphore.acquire();
                    semaphore.acquire(10);
                    add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
//                    semaphore.release();
                    semaphore.release(10);
                }
            });
        }
        service.shutdown();
    }

    private void add() {
        count ++;
        TimeUtil.timeSleep(2);
        System.out.println("当前count的值是：" + count);
    }

    public void testTrySemaphore() {
        ExecutorService service = Executors.newCachedThreadPool();
//        Semaphore semaphore = new Semaphore(20);
        Semaphore semaphore = new Semaphore(2);

        for (int i = 0; i < 20; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            service.submit(() -> {
//                if (semaphore.tryAcquire(10)) {
                try {
                    if (semaphore.tryAcquire(2000, TimeUnit.MILLISECONDS)) {
                        addTry();
                        System.out.println("当前1：" + Thread.currentThread().getName());
                        semaphore.release();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前：" + Thread.currentThread().getName());
            });
        }
        service.shutdown();
    }

    private void addTry() {
        tryCount ++;
        TimeUtil.timeSleep(2);
        System.out.println("当前count的值是：" + tryCount);
    }
}
