/**
 * 
 */
package com.spring.framework.example.service.impl;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.spring.framework.example.repository.AccountRepository;
import com.spring.framework.example.repository.impl.JdbcAccountRepository;
import com.spring.framework.example.service.TransferService;

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
	 * @see com.spring.framework.example.service.TransferService#transfer(float, java.lang.String, java.lang.String)
	 */
	@Override
	public void transfer(float money, String address, String street) {
		System.out.println(money + " " + address + " " + street);
	}

	/* (non-Javadoc)
	 * @see com.spring.framework.example.service.TransferService#printDataSource()
	 */
	@Override
	public void printDataSource() {
		System.out.println(((DriverManagerDataSource)((JdbcAccountRepository)accountRepository).getDataSource()).getUsername());
		
	}
}
