package com.learning.zookeeper.configurationcenter2.service;

import com.learning.zookeeper.config.ZkConfig;
import com.learning.zookeeper.configurationcenter2.IWatcher;
import com.learning.zookeeper.configurationcenter2.watcher.ZkHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZkService2 implements IWatcher {
    @Autowired
    private ZkConfig zkConfig;
    private ZkHelper helper;

    public void doSomething() {
        helper = new ZkHelper(zkConfig, this);
        helper.aWait();

        try {
            Thread.sleep(300000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void process(byte[] data) {
        if (data == null) {
            System.out.println("停止服务。。。。。。");
            helper.aWait();

        } else {

            System.out.println("获得的地址是：" + new String(data));
        }
    }
}
