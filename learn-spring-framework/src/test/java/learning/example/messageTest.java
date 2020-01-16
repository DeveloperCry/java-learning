/**
 * 
 */
package learning.example;

import learning.example.service.impl.MessageService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Xiong.Liu
 *
 */
public class messageTest {

	private ApplicationContext context = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {"example/applicationContext.xml"});
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void messageSourceTest() {
		MessageSource source = new ClassPathXmlApplicationContext("example/applicationContext.xml");
		String message = source.getMessage("message", null, "Default", null);
		
		System.out.println(message);
	}
	
	@Test
	public void argumentsMessageTest() {
		System.out.println("==========start");
		MessageService messageService = context.getBean("messageService", MessageService.class);
		messageService.execute();
		System.out.println("==========end");
	}

}
