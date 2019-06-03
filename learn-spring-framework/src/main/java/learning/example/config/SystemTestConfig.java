/**
 * 
 */
package learning.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Xiong.Liu
 *
 */
@Configuration
@Import({ServiceConfig.class, RepositoryConfig.class})
public class SystemTestConfig {
	@Bean
	public DataSource dataSource() {
		return null;
	}
}
