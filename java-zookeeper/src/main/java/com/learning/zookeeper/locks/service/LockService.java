package com.learning.zookeeper.locks.service;

import com.learning.zookeeper.config.ZkConfig;
import com.learning.zookeeper.locks.lock.DistributedLock;
import com.learning.zookeeper.utils.ZkUtil;
import org.apache.zookeeper.ZooKeeper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class LockService {
    @Autowired
    private ZkConfig zkConfig;

    private static final int THREAD_NUMBER = 10;

    public void logic() {
        ZooKeeper zooKeeper = ZkUtil.getZookeeper(zkConfig, true);
        ExecutorService service = Executors.newFixedThreadPool(THREAD_NUMBER);

        CyclicBarrier barrier = new CyclicBarrier(THREAD_NUMBER);

        for (int i = 0; i < THREAD_NUMBER; i++) {
            service.submit(() -> {
                DistributedLock lock = new DistributedLock(zooKeeper);
                lock.setThreadName(Thread.currentThread().getName());
                try {
                    barrier.await();
                    lock.lock();
                    System.out.println("当前执行的线程是：" + Thread.currentThread().getName());
//                    TimeUnit.MILLISECONDS.sleep(1000);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                DistributedLock lock = new DistributedLock(zooKeeper);
//                lock.setThreadName(Thread.currentThread().getName());
//                try {
//                    lock.lock();
//                    System.out.println("当前执行的线程是：" + Thread.currentThread().getName());
//                    TimeUnit.MILLISECONDS.sleep(1000);
//                    lock.unlock();
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//        }

//        try {
//            TimeUnit.MILLISECONDS.sleep(1000000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        service.shutdown();
    }
}
