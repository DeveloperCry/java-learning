/**
 * 
 */
package learning.mode.template;

/**
 * @author Xiong.Liu
 *
 */
public class Tea extends Beverage {

	/* (non-Javadoc)
	 * @see Beverage#brew()
	 */
	@Override
	protected void brew() {
		System.out.println("add tea.");
	}

	/* (non-Javadoc)
	 * @see Beverage#addCondiments()
	 */
	@Override
	protected void addCondiments() {
		System.out.println("add lemon.");
	}

}
