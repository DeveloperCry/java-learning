package com.learning.zookeeper.configurationcenter2.watcher;

import com.learning.zookeeper.config.ZkConfig;
import com.learning.zookeeper.configurationcenter2.IWatcher;
import com.learning.zookeeper.configurationcenter2.utils.ZkUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

@Slf4j
public class ZkHelper implements Watcher, AsyncCallback.StatCallback, AsyncCallback.DataCallback {
    private final static String CONFIG_IP_PATH = "/ip";
    private ZooKeeper zooKeeper;
    private IWatcher watcher;

    public ZkHelper(ZkConfig zkConfig, IWatcher watcher) {
        this.watcher = watcher;
        this.zooKeeper = ZkUtil.getZookeeper(zkConfig);
    }

    public void aWait() {
        //如果路径存在的话，就会执行callback，同时注册一个watcher去监听该路径下的节点或数据是否有修改
        this.zooKeeper.exists(CONFIG_IP_PATH, this, this, "exists");
    }

    // StatCallback
    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
        if (CONFIG_IP_PATH.equals(path) && stat != null) {
            System.out.println("执行" + ctx + "中的回调函数");
            this.zooKeeper.getData(CONFIG_IP_PATH, this, this, "IP");
        }

    }


    // watch
    @Override
    public void process(WatchedEvent event) {

        System.out.println("helper：" + event);
        Event.EventType type = event.getType();

        if (Event.EventType.NodeCreated.equals(type) || Event.EventType.NodeDataChanged.equals(type)) {
            this.zooKeeper.getData(CONFIG_IP_PATH, this, this, type);
        }

        if (Event.EventType.NodeDeleted.equals(type)) {
            this.watcher.process(null);
        }
    }

    // DataCallback
    @Override
    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
        System.out.println("执行" + ctx + "中的回调函数");
        if (data != null) {
            this.watcher.process(data);
        }
    }
}
