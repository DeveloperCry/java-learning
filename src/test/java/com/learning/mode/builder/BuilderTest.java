/**
 * 
 */
package com.learning.mode.builder;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Xiong.Liu
 *
 */
public class BuilderTest {

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
		Builder builder = new Worker();
		Engineer engineer = new Engineer();
		engineer.conduct(builder);
		House house = builder.createHouse();
		house.show();
	}

}
