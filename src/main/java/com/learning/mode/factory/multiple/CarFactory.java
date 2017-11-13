/**
 * 
 */
package com.learning.mode.factory.multiple;

import com.learning.mode.factory.simple.Car;
import com.learning.mode.factory.simple.Vehicle;

/**
 * @author Xiong.Liu
 *
 */
public class CarFactory implements Creator{

	/* (non-Javadoc)
	 * @see com.learning.mode.factory.general.Creator#factoryMethod()
	 */
	@Override
	public Vehicle factoryMethod() {
		return new Car();
	}

}
