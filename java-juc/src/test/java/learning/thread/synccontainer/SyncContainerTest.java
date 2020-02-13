package learning.thread.synccontainer;

import learning.constant.Constants;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SyncContainerTest {
    public static void main(String[] args) throws InterruptedException {
        SyncContainer container = new SyncContainer();

        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(Constants.TOTAL_THREAD);
        CountDownLatch countDownLatch = new CountDownLatch(Constants.TOTAL_REQUEST);
        for (int i = 0; i < Constants.TOTAL_REQUEST; i++) {
            executorService.submit(() -> {
                try {
                    semaphore.acquire();
                    container.addCommonList(2);
                    container.addCommonSet();
                    container.addCommonMap();
                    container.addSynchronizedList(2);
                    container.addSynchronizedSet();
                    container.addSynchronizedMap();
                    container.addHashTable();
                    container.addConcurrentHashMap();
                    container.addVector(4);
                    container.addConcurrentSkipListMap();
                    container.addConcurrentSkipListSet();
                    container.addCopyOnWriteArrayList(4);
                    container.addCopyOnWriteArraySet();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("CommonList 个数：" + container.getCommonList().size());
        System.out.println("CommonSet 个数：" + container.getCommonSet().size());
        System.out.println("CommonMap 个数：" + container.getCommonMap().size());
        System.out.println("HashTable 个数：" + container.getHashTable().size());
        System.out.println("Vector 个数：" + container.getVector().size());
        System.out.println("ConcurrentHashMap 个数：" + container.getConcurrentHashMap().size());
        System.out.println("ConcurrentSkipListMap 个数：" + container.getConcurrentSkipListMap().size());
        System.out.println("ConcurrentSkipListSet 个数：" + container.getConcurrentSkipListSet().size());
        System.out.println("CopyOnWriteArrayList 个数：" + container.getCopyOnWriteArrayList().size());
        System.out.println("CopyOnWriteArraySet 个数：" + container.getCopyOnWriteArraySet().size());
        System.out.println("SynchronizedList 个数：" + container.getSynchronizedList().size());
        System.out.println("SynchronizedSet 个数：" + container.getSynchronizedSet().size());
        System.out.println("SynchronizedMap 个数：" + container.getSynchronizedMap().size());

    }
}
