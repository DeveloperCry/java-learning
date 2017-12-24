/**
 * 
 */
package com.learning.mode.mediator;

/**
 * @author Milier
 *
 */
public class ConcreteMediator implements Mediator{
	
	private ConcreteColleague1 colleague1;
	private ConcreteColleague2 colleague2;
	
	/**
	 * @param colleague1 the colleague1 to set
	 */
	public void setColleague1(ConcreteColleague1 colleague1) {
		this.colleague1 = colleague1;
	}

	/**
	 * @param colleague2 the colleague2 to set
	 */
	public void setColleague2(ConcreteColleague2 colleague2) {
		this.colleague2 = colleague2;
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.mediator.Mediator#send(java.lang.String, com.learning.mode.mediator.Colleague)
	 */
	@Override
	public void send(String message, Colleague colleague) {
		if (colleague == colleague1) {
			colleague2.notify(message);
		} else if (colleague == colleague2) {
			colleague1.notify(message);
		} else {
			System.out.println("Error!");
		}
		
	}

}
