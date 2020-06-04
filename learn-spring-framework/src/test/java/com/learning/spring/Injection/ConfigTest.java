/**
 * 
 */
package com.learning.spring.Injection;

import com.learning.spring.config.ConfigB;
import com.learning.spring.config.JavaCentricAppConfig;
import com.learning.spring.config.SystemTestConfig;
import com.learning.spring.injection.Bar;
import com.learning.spring.injection.Baz;
import com.learning.spring.service.TransferService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
