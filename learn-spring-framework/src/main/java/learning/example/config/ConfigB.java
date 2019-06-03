/**
 * 
 */
package learning.example.config;

import learning.example.injection.Bar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Xiong.Liu
 *
 */
@Configuration
@Import(ConfigA.class)
public class ConfigB {
	@Bean
	public Bar aBar() {//The name of method shouldn't be the same as it in ConfigA
		System.out.println("This is B");
		return new Bar();
	}
}
