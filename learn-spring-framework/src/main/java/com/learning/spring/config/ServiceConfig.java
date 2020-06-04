/**
 * 
 */
package com.learning.spring.config;

import com.learning.spring.repository.AccountRepository;
import com.learning.spring.service.TransferService;
import com.learning.spring.service.impl.TransferServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
