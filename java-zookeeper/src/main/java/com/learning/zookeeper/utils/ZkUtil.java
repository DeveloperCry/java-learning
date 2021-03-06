package com.learning.zookeeper.utils;

import com.learning.zookeeper.config.ZkConfig;
import com.learning.zookeeper.configurationcenter2.watcher.DefaultWatcher;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;

public class ZkUtil {
    private final static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zk;

    public static ZooKeeper getZookeeper(ZkConfig zkConfig) {
        return getZookeeper(zkConfig, false);
    }

    public static ZooKeeper getZookeeper(ZkConfig zkConfig, boolean isLock) {
        DefaultWatcher watcher = new DefaultWatcher(countDownLatch);
        try {
            zk = new ZooKeeper(zkConfig.getUrl() + (isLock ? zkConfig.getLockPath() : zkConfig.getConfigCenterPath()), zkConfig.getTimeOut(), watcher);
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
