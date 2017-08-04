/**
 * 
 */
package com.spring.fremework.example.aspect;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.framework.example.aspect.SystemArchitecture;
import com.spring.fremework.BaseTest;

/**
 * @author Xiong.Liu
 *
 */
//@Aspect
public class SystemArchitectureTest extends BaseTest{
	
	@Autowired
	private SystemArchitecture systemArchitecture;

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
	public void test() {
		systemArchitecture.businessService();
	}

}
