/**
 * 
 */
package com.learning.mode.factory.abs;

/**
 * @author Xiong.Liu
 *
 */
public class AppleFactory implements ElectronicFactory{

	/* (non-Javadoc)
	 * @see com.learning.mode.factory.abs.ElectronicFactory#produceComputer()
	 */
	@Override
	public Computer produceComputer() {
		return new AppleComputer();
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.factory.abs.ElectronicFactory#produceTelephone()
	 */
	@Override
	public Telephone produceTelephone() {
		return new AppleTelephone();
	}

}
