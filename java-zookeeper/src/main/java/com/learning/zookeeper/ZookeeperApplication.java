package com.learning.zookeeper;

import com.learning.zookeeper.api.client.ZkClient;
import com.learning.zookeeper.configurationcenter2.service.ZkService2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ZookeeperApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ZookeeperApplication.class, args);
        ZkClient client = context.getBean(ZkClient.class);
//        ZkService service = context.getBean(ZkService.class);
        ZkService2 service2 = context.getBean(ZkService2.class);
        try {
//            client.runZK();
//            service.doSomething();
            service2.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
