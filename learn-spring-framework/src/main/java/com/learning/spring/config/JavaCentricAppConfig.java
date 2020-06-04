/**
 * 
 */
package com.learning.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author Xiong.Liu
 *
 */
@Configuration
@ImportResource("classpath:/com/spring/framework/example/injection/properties-config.xml")
public class JavaCentricAppConfig {
	@Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    public DataSource dataSource() {
    	System.out.println(username);
        return new DriverManagerDataSource(url, username, password);
    }
}
