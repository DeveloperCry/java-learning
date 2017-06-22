/**
 * 
 */
package com.spring.framework.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.spring.framework.example.injection.Baz;

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
