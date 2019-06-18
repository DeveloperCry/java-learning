/**
 * 
 */
package learning.example.config;

import javax.sql.DataSource;

import learning.example.repository.AccountRepository;
import learning.example.repository.impl.JdbcAccountRepository;
import learning.example.service.TransferService;
import learning.example.service.impl.TransferServiceImpl;
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
