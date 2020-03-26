package com.learning.zookeeper.configurationcenter.watcher;

import com.learning.zookeeper.config.ZkConfig;
import com.learning.zookeeper.configurationcenter.entity.Center;
import com.learning.zookeeper.utils.ZkUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.AsyncCallback;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class ZkHelper implements Watcher, AsyncCallback.StatCallback, AsyncCallback.DataCallback {
    private final static String CONFIG_IP_PATH = "/ip";
    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private ZooKeeper zooKeeper;
    private Center center;

    public ZkHelper(ZkConfig zkConfig) {
        this.zooKeeper = ZkUtil.getZookeeper(zkConfig);
    }

    public void aWait() {
        //如果路径存在的话，就会执行callback，同时注册一个watcher去监听该路径下的节点或数据是否有修改
        this.zooKeeper.exists(CONFIG_IP_PATH, this, this, "exists");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // StatCallback
    @Override
    public void processResult(int rc, String path, Object ctx, Stat stat) {
//        System.out.println("传入的参数：" + (String) ctx);
//        if (StringUtils.isBlank(path)) {
//            log.info("路径\"" + CONFIG_IP_PATH + "\"还没有创建");
//        } else {
//            log.info("当前路径是：" + path);
//        }
//        System.out.println(stat);
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
        switch (type) {
            case None:
                break;
            case NodeCreated:
                this.zooKeeper.getData(CONFIG_IP_PATH, this, this, "");
                break;
            case NodeDeleted:
                countDownLatch = new CountDownLatch(1);
                this.getCenter().setIpAddress("");
                break;
            case NodeDataChanged:
                this.zooKeeper.getData(CONFIG_IP_PATH, this, this, "");
                break;
            case NodeChildrenChanged:
                break;
            case DataWatchRemoved:
                break;
            case ChildWatchRemoved:
                break;
            case PersistentWatchRemoved:
                break;
        }

    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public Center getCenter() {
        return this.center;
    }

    // DataCallback
    @Override
    public void processResult(int rc, String path, Object ctx, byte[] data, Stat stat) {
//        System.out.println("开始获取值");
        if (data != null) {
            this.center = new Center();
            this.center.setIpAddress(new String(data));
            countDownLatch.countDown();
        }
    }
}
