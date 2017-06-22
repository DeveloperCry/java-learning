/**
 * 
 */
package com.spring.fremework.example.Injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.framework.example.config.ConfigB;
import com.spring.framework.example.injection.Bar;
import com.spring.framework.example.injection.Baz;

/**
 * @author Xiong.Liu
 *
 */
public class ConfigTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigB.class);
		
		Bar bar = context.getBean(Bar.class);
		Baz baz = context.getBean(Baz.class);

	}

}
