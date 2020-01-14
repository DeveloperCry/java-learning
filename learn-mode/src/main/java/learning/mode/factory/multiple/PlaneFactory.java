/**
 * 
 */
package learning.mode.factory.multiple;

import learning.mode.factory.simple.Plane;
import learning.mode.factory.simple.Vehicle;

/**
 * @author Xiong.Liu
 *
 */
public class PlaneFactory implements Creator{

	/* (non-Javadoc)
	 * @see learning.mode.factory.general.Creator#factoryMethod()
	 */
	@Override
	public Vehicle factoryMethod() {
		// TODO Auto-generated method stub
		return new Plane();
	}

}
