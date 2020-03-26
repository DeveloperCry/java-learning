package com.learning.zookeeper.configurationcenter.utils;

import com.learning.zookeeper.config.ZkConfig;
import com.learning.zookeeper.configurationcenter.watcher.DefaultWatcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class ZkUtil {
    private final static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zk;

    public static ZooKeeper getZookeeper(ZkConfig zkConfig) {
        DefaultWatcher watcher = new DefaultWatcher(countDownLatch);
        try {
            zk = new ZooKeeper(zkConfig.getUrl() + zkConfig.getConfigCenterPath(), zkConfig.getTimeOut(), watcher);
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return zk;
    }

    public static void close() {
        if (zk != null) {
            try {
                zk.close();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
