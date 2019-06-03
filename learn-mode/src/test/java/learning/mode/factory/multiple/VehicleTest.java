/**
 * 
 */
package learning.mode.factory.multiple;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import learning.mode.factory.simple.Vehicle;

/**
 * @author Xiong.Liu
 *
 */
public class VehicleTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCar() {
		Creator creator = new CarFactory();
		Vehicle vehicle = creator.factoryMethod();
		vehicle.run();
	}
	
	@Test
	public void testPlane() {
		Creator creator = new PlaneFactory();
		Vehicle vehicle = creator.factoryMethod();
		vehicle.fly();
	}

}
