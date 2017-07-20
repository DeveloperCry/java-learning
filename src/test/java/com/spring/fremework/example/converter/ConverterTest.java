/**
 * 
 */
package com.spring.fremework.example.converter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.spring.framework.example.converter.StringToInteger;

/**
 * @author Xiong.Liu
 *
 */
public class ConverterTest {

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
	public void stringToIntegerTest() {
		StringToInteger st = new StringToInteger();
		Integer num = st.convert("2345");
		assertEquals(num, (Integer)2345);
	}

}
