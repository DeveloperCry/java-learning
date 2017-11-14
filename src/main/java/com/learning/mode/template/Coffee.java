/**
 * 
 */
package com.learning.mode.template;

/**
 * @author Xiong.Liu
 *
 */
public class Coffee extends Beverage {

	/* (non-Javadoc)
	 * @see com.learning.mode.template.Beverage#brew()
	 */
	@Override
	protected void brew() {
		System.out.println("add coffee.");
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.template.Beverage#addCondiments()
	 */
	@Override
	protected void addCondiments() {
		System.out.println("add sugar and milk.");
	}
	
	/* (non-Javadoc)
	 * @see com.learning.mode.template.Beverage#customWantsCondiments()
	 */
	@Override
	protected boolean customWantsCondiments() {
		return false;
	}

}
