/**
 * 
 */
package com.learning.mode.factory.simple;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	public void test() {
		System.out.println("This is the car.");
		Creator creator = new VehicelFactory();
		Car car = creator.createVehicle(Car.class);
		car.run();
		car.fly();
		car.swim();
	}
	
	@Test
	public void testPlane() {
		System.out.println("This is the plane.");
		Creator creator = new VehicelFactory();
		Vehicle vehicle = creator.createVehicle(Plane.class);
		vehicle.run();
		vehicle.fly();
		vehicle.swim();
	}

}
