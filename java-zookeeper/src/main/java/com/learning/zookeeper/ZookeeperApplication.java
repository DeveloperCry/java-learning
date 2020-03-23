package com.learning.zookeeper;

import com.learning.zookeeper.client.ZkClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ZookeeperApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ZookeeperApplication.class, args);
        ZkClient client = context.getBean(ZkClient.class);
        try {
            client.runZK();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
