/**
 * 
 */
package com.spring.framework.example.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.spring.framework.example.repository.AccountRepository;
import com.spring.framework.example.repository.impl.JdbcAccountRepository;
import com.spring.framework.example.service.TransferService;
import com.spring.framework.example.service.impl.TransferServiceImpl;

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
