/**
 * 
 */
package com.learning.spring.config;

import javax.sql.DataSource;

import com.learning.spring.repository.AccountRepository;
import com.learning.spring.repository.impl.JdbcAccountRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
