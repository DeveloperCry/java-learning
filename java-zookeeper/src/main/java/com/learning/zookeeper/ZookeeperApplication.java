package com.learning.zookeeper;

import com.learning.zookeeper.api.client.ZkClient;
import com.learning.zookeeper.configurationcenter.service.ZkService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ZookeeperApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ZookeeperApplication.class, args);
        ZkClient client = context.getBean(ZkClient.class);
        ZkService service = context.getBean(ZkService.class);
        try {
//            client.runZK();
            service.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
