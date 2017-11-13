/**
 * 
 */
package com.learning.mode.factory.multiple;

import com.learning.mode.factory.simple.Boat;
import com.learning.mode.factory.simple.Vehicle;

/**
 * @author Xiong.Liu
 *
 */
public class BoatFactory implements Creator{

	/* (non-Javadoc)
	 * @see com.learning.mode.factory.general.Creator#factoryMethod()
	 */
	@Override
	public Vehicle factoryMethod() {
		return new Boat();
	}

}
