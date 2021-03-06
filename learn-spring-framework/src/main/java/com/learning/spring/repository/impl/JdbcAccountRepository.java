/**
 * 
 */
package com.learning.spring.repository.impl;

import javax.sql.DataSource;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.learning.spring.repository.AccountRepository;

/**
 * @author Xiong.Liu
 *
 */
@Configuration
@Repository
public class JdbcAccountRepository implements AccountRepository{
	private DataSource dataSource;

	public JdbcAccountRepository() {
	}

	public JdbcAccountRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	
	/**
	 * Gets dataSource
	 * @return the dataSource
	 */
	public DataSource getDataSource() {
		return dataSource;
	}
	
	
	
}
