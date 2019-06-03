/**
 * 
 */
package learning.mode.mediator;

import org.junit.Test;

/**
 * @author Milier
 *
 */
public class MediatorTest {

	@Test
	public void test() {
		ConcreteMediator mediator = new ConcreteMediator();
		ConcreteColleague1 colleague1 = new ConcreteColleague1(mediator);
		ConcreteColleague2 colleague2 = new ConcreteColleague2(mediator);
		
		
		mediator.setColleague1(colleague1);
		mediator.setColleague2(colleague2);
		
		colleague1.send("Hi colleague 2");
		colleague2.send("Hi colleague 1");
		colleague1.send("Hi colleagues");
	}

}
