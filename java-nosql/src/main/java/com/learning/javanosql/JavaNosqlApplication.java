package com.learning.javanosql;

import com.learning.javanosql.redis.service.RedisService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaNosqlApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JavaNosqlApplication.class, args);
        System.out.println("begin");
        RedisService redis = context.getBean(RedisService.class);
        redis.setName();
        redis.getName();
        System.out.println("hash ===============");
        redis.setUser();
        redis.getUser();
    }

}
