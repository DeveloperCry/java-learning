/**
 * 
 */
package com.spring.fremework.example.Injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.framework.example.config.ConfigB;
import com.spring.framework.example.config.JavaCentricAppConfig;
import com.spring.framework.example.config.SystemTestConfig;
import com.spring.framework.example.injection.Bar;
import com.spring.framework.example.injection.Baz;
import com.spring.framework.example.service.TransferService;

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

		ApplicationContext ctx1 = new AnnotationConfigApplicationContext(SystemTestConfig.class);
		
		TransferService transferService = ctx1.getBean(TransferService.class);
		transferService.transfer(10.9F, "zxcv", "sdfg");
		
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext("classpath:/com/spring/framework/example/injection/system-test-config.xml");
		TransferService transferService2 = ctx2.getBean(TransferService.class);
		transferService2.printDataSource();
		
		ApplicationContext ctx3 = new AnnotationConfigApplicationContext(JavaCentricAppConfig.class);
		
	}

}
