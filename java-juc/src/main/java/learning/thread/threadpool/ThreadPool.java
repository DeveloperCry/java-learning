package learning.thread.threadpool;

import lombok.Getter;

import java.util.concurrent.*;

@Getter
public class ThreadPool {
    // 创建一个执行程序，该执行程序使用一个工作线程在一个无界队列上操作
    private ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    // 创建一个线程池，该线程池重用在共享无界队列上操作的固定数量的线程。
    private ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    private ExecutorService fixedThreadFactoryPool = Executors.newFixedThreadPool(3, Executors.defaultThreadFactory());
    // 创建一个线程池，该线程池根据需要创建新线程，但将重用以前构造的可用线程。
    private ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    // 创建一个线程池，该线程池可以调度命令在给定延迟后运行，或定期执行
    // 这里传入的参数是要保留在池中的线程数，即使它们是空闲的
    // 有两个方法：submit()是里面就执行，和其他的线程池没有什么区别；schedule()就是可以执行定时任务线程
    private ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);
    // 使用可用处理器的数量作为其目标并行度级别创建工作窃取线程池，简单的说就是并发执行，优点类似parallelStream
    private ExecutorService workStealingPool = Executors.newWorkStealingPool();

    private int singleCount;
    private int fixedCount;
    private int fixedFactoryCount;
    private int cacheCount;
    private int scheduledCount;
    private int workStealingCount;


    public void singleThreadPool() {
        for (int i = 0; i < 5; i++) {
            singleThreadPool.submit(() -> {
                singleCount++;
                System.out.println(Thread.currentThread().getName() + "：当前singleCount：" + singleCount);
            });
        }
        singleThreadPool.shutdown();
    }

    public void fixedThreadPool() {
        for (int i = 0; i < 5; i++) {
            fixedThreadPool.submit(() -> {
                fixedCount++;
                System.out.println(Thread.currentThread().getName() + "：当前fixedCount：" + fixedCount);
            });
        }
        fixedThreadPool.shutdown();
    }

    public void fixedThreadFactoryPool() {
//        fixedThreadFactoryPool = Executors.newFixedThreadPool(2, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r, "factory线程");
//            }
//        });
//        fixedThreadFactoryPool = Executors.newFixedThreadPool(3, (r) -> {
//            Thread thread = new Thread(r, "factory线程" + Thread.currentThread().getId());
//            thread.setDaemon(true);
//            return thread;
//        });
        fixedThreadFactoryPool = Executors.newFixedThreadPool(3, new MyThreadFactory());
//        for (int i = 0; i < 5; i++) {
//            fixedThreadFactoryPool.submit(() -> {
//                fixedFactoryCount++;
//                System.out.println(Thread.currentThread().getName() + "：当前fixedFactoryCount：" + fixedFactoryCount);
//            });
//        }
        for (int i = 0; i < 5; i++) {
            fixedThreadFactoryPool.submit(new Task(String.valueOf(i)));
        }
        fixedThreadFactoryPool.shutdown();
    }

    class Task implements Runnable {
        private String name;
        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "：" + name);
        }
    }

    class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
//            thread.setDaemon(true);
            return thread;
        }
    }

    public void cachedThreadPool() {
        for (int i = 0; i < 5; i++) {
            cachedThreadPool.submit(() -> {
                cacheCount++;
                System.out.println(Thread.currentThread().getName() + "：当前cacheCount：" + cacheCount);
            });
        }
        cachedThreadPool.shutdown();
    }

    public void workStealingPool() {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            workStealingPool.submit(() -> {
                workStealingCount++;
                System.out.println(Thread.currentThread().getName() + "：当前workStealingCount：" + workStealingCount);
                countDownLatch.countDown();
            });
        }
//        TimeUtil.timeSleep(5);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        workStealingPool.shutdown();
    }

    public void scheduledThreadPool() {
        for (int i = 0; i < 5; i++) {
            scheduledThreadPool.schedule(()-> {
                scheduledCount++;
                System.out.println(Thread.currentThread().getName() + "：当前scheduledCount：" + scheduledCount);
            }, 5, TimeUnit.SECONDS);
//            scheduledThreadPool.submit(() -> {
//                scheduledCount++;
//                System.out.println(Thread.currentThread().getName() + "：当前scheduledCount：" + scheduledCount);
//            });
        }
        scheduledThreadPool.shutdown();
    }




}
