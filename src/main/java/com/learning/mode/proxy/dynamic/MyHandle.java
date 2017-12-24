/**
 * 
 */
package com.learning.mode.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Milier
 *
 */
public class MyHandle implements InvocationHandler{
	public Object object;
	
	public MyHandle(Object object) {
		this.object = object;
	}

	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = method.invoke(this.object, args);
		return result;
	}
	
}
