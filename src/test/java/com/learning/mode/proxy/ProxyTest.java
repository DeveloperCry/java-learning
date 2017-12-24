/**
 * 
 */
package com.learning.mode.proxy;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.learning.mode.proxy.dynamic.IPeople;
import com.learning.mode.proxy.dynamic.MyHandle;
import com.learning.mode.proxy.dynamic.People;

/**
 * @author Milier
 *
 */
public class ProxyTest {

	@Test
	public void testProxy() {
		ProxySubject proxySubject = new ProxySubject();
		
		proxySubject.request();
	}
	
	@Test
	public void testDynamicProxy() {
		IPeople iPeople = new People();
		iPeople.fun();
		InvocationHandler invocationHandler = new MyHandle(iPeople);
		
		ClassLoader loader = invocationHandler.getClass().getClassLoader();
		
		IPeople p = (IPeople) Proxy.newProxyInstance(loader, iPeople.getClass().getInterfaces(), invocationHandler);
		
		p.func();
	}

}
