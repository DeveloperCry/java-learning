/**
 * 
 */
package com.learning.mode.factory.abs;

/**
 * @author Xiong.Liu
 *
 */
public class HuaweiComputer implements Computer{

	/* (non-Javadoc)
	 * @see com.learning.mode.factory.abs.Computer#getProductInfo()
	 */
	@Override
	public String getProductInfo() {
		return "The hua wei computer is using the WINDOWS.";
	}

}
