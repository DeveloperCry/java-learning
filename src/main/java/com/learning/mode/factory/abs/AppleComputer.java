/**
 * 
 */
package com.learning.mode.factory.abs;

/**
 * @author Xiong.Liu
 *
 */
public class AppleComputer implements Computer{

	/* (non-Javadoc)
	 * @see com.learning.mode.factory.abs.Computer#getProductInfo()
	 */
	@Override
	public String getProductInfo() {
		return "The apple computer is using the MAC.";
	}

}
