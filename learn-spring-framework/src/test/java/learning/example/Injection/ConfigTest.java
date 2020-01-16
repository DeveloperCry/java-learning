/**
 * 
 */
package learning.example.Injection;

import learning.example.config.ConfigB;
import learning.example.config.JavaCentricAppConfig;
import learning.example.config.SystemTestConfig;
import learning.example.injection.Bar;
import learning.example.injection.Baz;
import learning.example.service.TransferService;
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
