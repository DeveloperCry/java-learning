package learning.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.format("线程%s正在执行.....\n", Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        long endTime = System.currentTimeMillis();
        System.out.format("创建线程用时：%d\n", endTime - startTime);

        for (int i = 0; i < 10; i++) {
            Future future = threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.format("线程%s正在执行.....\n", Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            try {
                System.out.format("线程%d%s。", i, future.get() == null ? "结束": "未结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }


        threadPool.shutdown();
        endTime = System.currentTimeMillis();
        System.out.format("创建线程用时：%d\n", endTime - startTime);
    }
}
