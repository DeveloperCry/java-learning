package com.learning.zookeeper.configurationcenter.service;

import com.learning.zookeeper.config.ZkConfig;
import com.learning.zookeeper.configurationcenter.entity.Center;
import com.learning.zookeeper.configurationcenter.watcher.ZkHelper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZkService {
    @Autowired
    private ZkConfig zkConfig;

    public void doSomething() {
        ZkHelper helper = new ZkHelper(zkConfig);
        Center center = new Center();
        helper.setCenter(center);
        helper.aWait();
        while (true) {
            String address = helper.getCenter().getIpAddress();
            if (StringUtils.isBlank(address)) {
                System.out.println("停止服务。。。。。。");
                helper.aWait();

            } else {

                System.out.println("获得的地址是：" + helper.getCenter().getIpAddress());
            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
