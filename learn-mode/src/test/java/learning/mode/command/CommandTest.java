/**
 * 
 */
package learning.mode.command;

import org.junit.Test;

import learning.mode.command.command.ConcreteCommand1;
import learning.mode.command.receiver.ConcreteReciver1;

/**
 * @author Milier
 *
 */
public class CommandTest {

	@Test
	public void test() {
		Invoker invoker = new Invoker();
		
		ConcreteReciver1 reciver1 = new ConcreteReciver1();
		ConcreteCommand1 command1 = new ConcreteCommand1(reciver1);
		
		invoker.setCommand(command1);
		invoker.action();
	}

}
