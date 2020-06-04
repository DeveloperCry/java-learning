/**
 * 
 */
package com.learning.spring.config;

import javax.sql.DataSource;

import com.learning.spring.repository.AccountRepository;
import com.learning.spring.repository.impl.JdbcAccountRepository;
import com.learning.spring.service.TransferService;
import com.learning.spring.service.impl.TransferServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

/**
 * @author Xiong.Liu
 *
 */
public class XMLCentricAppConfig {
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Bean
	public AccountRepository accountRepository() {
		return new JdbcAccountRepository(dataSource);
	}
	
	@Bean
	public TransferService transferService() {
		return new TransferServiceImpl(accountRepository);
	}
}
