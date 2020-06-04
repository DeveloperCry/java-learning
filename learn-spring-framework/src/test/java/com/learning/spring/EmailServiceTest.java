/**
 * 
 */
package com.learning.spring;

import java.util.ArrayList;
import java.util.List;

import com.learning.spring.service.impl.EmailServiceImpl;
import learning.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author Xiong.Liu
 *
 */
public class EmailServiceTest extends BaseTest {
	
	@Autowired
	private EmailServiceImpl emailServiceImpl;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSendEmail() {
		List<String> addressList = new ArrayList<>();
		addressList.add("t@com");
		addressList.add("q@com");
		addressList.add("f@com");
		
		this.emailServiceImpl.setBlackList(addressList);
		this.emailServiceImpl.sendEamil("q@com", "test email");
	}
}
