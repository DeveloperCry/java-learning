/**
 * 
 */
package com.learning.mode.proxy.dynamic;

/**
 * @author Milier
 *
 */
public class People implements IPeople {

	/* (non-Javadoc)
	 * @see com.learning.mode.proxy.dynamic.IPeople#fun()
	 */
	@Override
	public void fun() {
		System.out.println("This is the fun method.");
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.proxy.dynamic.IPeople#func()
	 */
	@Override
	public void func() {
		System.out.println("This is the func method.");

	}

}
