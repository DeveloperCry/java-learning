/**
 * 
 */
package learning.mode.factory.simple;

/**
 * @author Xiong.Liu
 *
 */
public class Boat extends Vehicle{

	/* (non-Javadoc)
	 * @see Vehicle#fly()
	 */
	@Override
	public void fly() {
		System.out.println("I am a boat, I cannot fly.");
	}

	/* (non-Javadoc)
	 * @see Vehicle#swim()
	 */
	@Override
	public void swim() {
		System.out.println("I am a boat, I can swim.");
	}

}
