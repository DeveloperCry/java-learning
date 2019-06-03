/**
 * 
 */
package learning.mode.factory.simple;

/**
 * @author Xiong.Liu
 *
 */
public class Car extends Vehicle{
	
	@Override
	public void run() {
		System.out.println("I am a car, I can run.");
	}

	/* (non-Javadoc)
	 * @see Vehicle#fly()
	 */
	@Override
	public void fly() {
		System.out.println("I am a car, I cannot fly.");
	}

	/* (non-Javadoc)
	 * @see Vehicle#swim()
	 */
	@Override
	public void swim() {
		System.out.println("I am a car, I cannot swim.");
	}
	
}
