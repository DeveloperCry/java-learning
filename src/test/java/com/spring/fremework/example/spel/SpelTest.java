/**
 * 
 */
package com.spring.fremework.example.spel;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import com.spring.framework.example.bean.Inventor;

/**
 * @author Xiong.Liu
 *
 */
public class SpelTest {

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
	public void helloSpelTest() {
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("'Hello World'");// if using "Hello world", there is an exception
		String message = (String) exp.getExpressionString();
		String value = (String) exp.getValue();
		
		System.out.println(message);//'Hello World'
		System.out.println(value);//Hello World
		System.out.println("===============");
		
		Expression exp2 = parser.parseExpression("'Hello World'.concat('!')");
		String message2 = (String) exp2.getExpressionString();// if using "Hello world", there is an exception
		String value2 = (String) exp2.getValue();
		
		System.out.println(message2);//'Hello World'
		System.out.println(value2);//Hello World
		System.out.println("===============");
	}
	
	@Test
	public void InventorTest() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.set(2011, 7, 9);
		
		Inventor tesla = new Inventor("Nikola Tesla", calendar.getTime(), "Serbian");
		
		ExpressionParser parser = new SpelExpressionParser();
		Expression exp = parser.parseExpression("name");
		
		EvaluationContext context = new StandardEvaluationContext(tesla);
		String name = (String) exp.getValue(context);
		System.out.println(name);
		System.out.println((String) exp.getValue(tesla));
	}

}
