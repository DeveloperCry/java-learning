package com.learning.zookeeper.configurationcenter2.watcher;

import lombok.AllArgsConstructor;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

import java.util.concurrent.CountDownLatch;

@AllArgsConstructor
public class DefaultWatcher implements Watcher {
    private CountDownLatch countDownLatch;

    @Override
    public void process(WatchedEvent event) {
        System.out.println("默认Watcher：" + event);
        if (event.getState() == Event.KeeperState.SyncConnected) {
            System.out.println("默认Watcher：链接成功。。。。。");
            countDownLatch.countDown();
        }
    }
}
