/**
 * 
 */
package com.learning.mode.factory.simple;

/**
 * @author Xiong.Liu
 *
 */
public class Plane extends Vehicle{

	/* (non-Javadoc)
	 * @see com.learning.mode.factory.simple.Vehicle#fly()
	 */
	@Override
	public void fly() {
		System.out.println("I am a airplane, I can fly.");
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.factory.simple.Vehicle#swim()
	 */
	@Override
	public void swim() {
		System.out.println("I am a airplane, I cannot swim.");
	}

}
