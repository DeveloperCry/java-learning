/**
 * 
 */
package learning.mode.factory.multiple;

import learning.mode.factory.simple.Boat;
import learning.mode.factory.simple.Vehicle;

/**
 * @author Xiong.Liu
 *
 */
public class BoatFactory implements Creator{

	/* (non-Javadoc)
	 * @see learning.mode.factory.general.Creator#factoryMethod()
	 */
	@Override
	public Vehicle factoryMethod() {
		return new Boat();
	}

}
