package com.spring.fremework.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.framework.example.injection.ComplexObject;

public class Boot {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"example/applicationContext.xml"});
		ComplexObject parent = (ComplexObject)ctx.getBean("parent");
		System.out.println(parent);
	}
}
