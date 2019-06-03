/**
 * 
 */
package learning.mode.factory.multiple;

import learning.mode.factory.simple.Car;
import learning.mode.factory.simple.Vehicle;

/**
 * @author Xiong.Liu
 *
 */
public class CarFactory implements Creator{

	/* (non-Javadoc)
	 * @see learning.mode.factory.general.Creator#factoryMethod()
	 */
	@Override
	public Vehicle factoryMethod() {
		return new Car();
	}

}
