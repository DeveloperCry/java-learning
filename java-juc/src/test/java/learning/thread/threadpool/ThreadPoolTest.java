package learning.thread.threadpool;


public class ThreadPoolTest {
    public static void main(String[] args) {

        ThreadPool threadPool = new ThreadPool();
        threadPool.workStealingPool();
        threadPool.singleThreadPool();
        threadPool.fixedThreadPool();
        threadPool.fixedThreadFactoryPool();
        threadPool.cachedThreadPool();
        threadPool.scheduledThreadPool();
    }
}
