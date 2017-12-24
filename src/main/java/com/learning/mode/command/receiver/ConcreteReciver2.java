/**
 * 
 */
package com.learning.mode.command.receiver;

/**
 * @author Milier
 *
 */
public class ConcreteReciver2 implements Receiver{

	/* (non-Javadoc)
	 * @see com.learning.mode.command.receiver.Receiver#doSomething()
	 */
	@Override
	public void doSomething() {
		System.out.println("This is receiver 2 do some thing.");
	}

}
