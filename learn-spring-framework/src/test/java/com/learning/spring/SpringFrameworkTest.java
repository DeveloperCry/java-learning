/**
 * 
 */
package com.learning.spring;

import com.learning.spring.listener.SimpleMovieLister;
import com.learning.spring.service.BlogService;
import com.learning.spring.service.impl.BlogServiceImpl;
import com.learning.spring.service.impl.ClientService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author Xiong.Liu
 *
 */
public class SpringFrameworkTest {

	ApplicationContext context = null;
	
//	@Autowired
//	private SimpleMovieLister lister;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {"mapper/services.xml", "mapper/daos.xml"});
		//Composing XML-based configuration metadata start
		//context = new ClassPathXmlApplicationContext(new String[] {"com/spring/framework/example/applicationContext.xml"});
		//Composing XML-based configuration metadata end
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void BlogServiceImplTest() {
		BlogServiceImpl serviceImpl = context.getBean("blogService", BlogServiceImpl.class);
		serviceImpl.getBlog();
		
		BlogServiceImpl serviceImpl2 = context.getBean("blogService", BlogServiceImpl.class);
		
		Assert.assertTrue(serviceImpl.equals(serviceImpl2));
		Assert.assertTrue(serviceImpl == serviceImpl2);
	}
	
	@Test
	public void BlogServiceTest() {
		
		GenericApplicationContext ctx = new GenericApplicationContext();
		new XmlBeanDefinitionReader(ctx).loadBeanDefinitions(new String[] {"mapper/services.xml", "mapper/daos.xml"});
		ctx.refresh();//shouldn't be lost
		BlogService service = ctx.getBean("blogService", BlogService.class);
		service.getBlog();
	}
	
	@Test
	public void ClientServiceTest() {
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		// createInstance called one time since the get bean twice.
		ClientService service = context.getBean("clientService", ClientService.class);

		ClientService service2 = context.getBean("clientService", ClientService.class);
		
		Assert.assertTrue(service.equals(service2));
		Assert.assertTrue(service == service2);
	}
	
	@Test
	public void clientServiceLocatorTest() {
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		// createInstance called one time since the get bean twice.
		ClientService service = context.getBean("clientServiceLocator", ClientService.class);

		ClientService service2 = context.getBean("clientServiceLocator", ClientService.class);
		
		Assert.assertTrue(service.equals(service2));
		Assert.assertTrue(service == service2);
	}
	
	@Test
	public void simpleMovieListerTest() {
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
		SimpleMovieLister lister = context.getBean("simpleMovieLister", SimpleMovieLister.class);
		lister.printMovie();
	}
	

}
