/**
 * 
 */
package com.learning.mode.command.command;

import com.learning.mode.command.receiver.Receiver;

/**
 * @author Milier
 *
 */
public class ConcreteCommand2 implements Command{
	
	private Receiver receiver;
	
	/**
	 * 
	 */
	public ConcreteCommand2(Receiver receiver) {
		this.receiver = receiver;
	}

	/* (non-Javadoc)
	 * @see com.learning.mode.command.command.Command#execute()
	 */
	@Override
	public void execute() {
		this.receiver.doSomething();
		
	}

}
