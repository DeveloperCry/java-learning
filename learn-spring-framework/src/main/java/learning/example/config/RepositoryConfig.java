/**
 * 
 */
package learning.example.config;

import javax.sql.DataSource;

import learning.example.repository.AccountRepository;
import learning.example.repository.impl.JdbcAccountRepository;
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
