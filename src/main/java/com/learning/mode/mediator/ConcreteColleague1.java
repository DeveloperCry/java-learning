/**
 * 
 */
package com.learning.mode.mediator;

/**
 * @author Milier
 *
 */
public class ConcreteColleague1 extends Colleague{

	/**
	 * @param mediator
	 */
	public ConcreteColleague1(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.mediator.Colleague#notify(java.lang.String)
	 */
	@Override
	public void notify(String message) {
		System.out.println("colleague 1 get the message: " + message);
		
	}

}
