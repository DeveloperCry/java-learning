/**
 * 
 */
package learning.mode.mediator;

/**
 * @author Milier
 *
 */
public class ConcreteColleague2 extends Colleague{

	/**
	 * @param mediator
	 */
	public ConcreteColleague2(Mediator mediator) {
		super(mediator);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see Colleague#notify(java.lang.String)
	 */
	@Override
	public void notify(String message) {
		System.out.println("colleague 2 get the message: " + message);
		
	}

}
