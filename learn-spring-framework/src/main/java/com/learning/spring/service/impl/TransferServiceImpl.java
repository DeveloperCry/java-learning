/**
 * 
 */
package com.learning.spring.service.impl;

import com.learning.spring.repository.AccountRepository;
import com.learning.spring.repository.impl.JdbcAccountRepository;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.learning.spring.service.TransferService;

/**
 * @author Xiong.Liu
 *
 */
@Service
public class TransferServiceImpl implements TransferService{
	
	private AccountRepository accountRepository;

	public TransferServiceImpl() {
	}
	
	public TransferServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	/* (non-Javadoc)
	 * @see TransferService#transfer(float, java.lang.String, java.lang.String)
	 */
	@Override
	public void transfer(float money, String address, String street) {
		System.out.println(money + " " + address + " " + street);
	}

	/* (non-Javadoc)
	 * @see TransferService#printDataSource()
	 */
	@Override
	public void printDataSource() {
		System.out.println(((DriverManagerDataSource)((JdbcAccountRepository)accountRepository).getDataSource()).getUsername());
		
	}
}
