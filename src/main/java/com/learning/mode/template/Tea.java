/**
 * 
 */
package com.learning.mode.template;

/**
 * @author Xiong.Liu
 *
 */
public class Tea extends Beverage {

	/* (non-Javadoc)
	 * @see com.learning.mode.template.Beverage#brew()
	 */
	@Override
	protected void brew() {
		System.out.println("add tea.");
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.template.Beverage#addCondiments()
	 */
	@Override
	protected void addCondiments() {
		System.out.println("add lemon.");
	}

}
