/**
 * 
 */
package learning.example.config;

import learning.example.injection.Baz;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Xiong.Liu
 *
 */
@Configuration
public class ConfigA {
	@Bean
	public Baz aBaz() {
		System.out.println("This is A");
		return new Baz();
	}
}
