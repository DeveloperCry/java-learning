package com.learning.zookeeper.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("zookeeper")
public class ZkConfig {
    private String url;
    private int timeOut;
    private String configCenterPath;
    private String lockPath;
}
