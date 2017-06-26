/**
 * 
 */
package com.spring.framework.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.framework.example.repository.AccountRepository;
import com.spring.framework.example.service.TransferService;
import com.spring.framework.example.service.impl.TransferServiceImpl;

/**
 * @author Xiong.Liu
 *
 */
@Configuration
public class ServiceConfig {
	@Bean
	public TransferService transferService(AccountRepository accountRepository) {
		return new TransferServiceImpl(accountRepository);
	}
}
