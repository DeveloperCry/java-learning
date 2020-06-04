package com.learning.spring.Injection;

import javax.annotation.Resource;

import com.learning.spring.injection.ComplexObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:com/spring/framework/example/applicationContext.xml")
public class ComplexObjectTest {

	//There are two bean using the same class. Using @Resource can specify which bean will be used
	@Resource(name="child")
	private ComplexObject complexObject;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		System.out.println(complexObject);
		System.out.println(complexObject.getAdminEmails());
	}

}
