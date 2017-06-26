/**
 * 
 */
package com.spring.framework.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.framework.example.repository.AccountRepository;
import com.spring.framework.example.repository.impl.JdbcAccountRepository;

/**
 * @author Xiong.Liu
 *
 */
@Configuration
public class RepositoryConfig {
	@Bean
	public AccountRepository accountRepository(DataSource dataSource) {
		return new JdbcAccountRepository(dataSource);
	}
}
