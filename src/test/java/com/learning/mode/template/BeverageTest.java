/**
 * 
 */
package com.learning.mode.template;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Xiong.Liu
 *
 */
public class BeverageTest {

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
	public void testTea() {
		System.out.println("I need a tea=======================");
		Beverage beverage = new Tea();
		beverage.prepareBeverage();
	}
	
	@Test
	public void testCoffee() {
		System.out.println("I need a tea=======================");
		Beverage beverage = new Coffee();
		beverage.prepareBeverage();
	}


}
