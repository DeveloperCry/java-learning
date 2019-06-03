/**
 * 
 */
package learning.mode.template;

/**
 * @author Xiong.Liu
 *
 */
public class Coffee extends Beverage {

	/* (non-Javadoc)
	 * @see Beverage#brew()
	 */
	@Override
	protected void brew() {
		System.out.println("add coffee.");
	}

	/* (non-Javadoc)
	 * @see Beverage#addCondiments()
	 */
	@Override
	protected void addCondiments() {
		System.out.println("add sugar and milk.");
	}
	
	/* (non-Javadoc)
	 * @see Beverage#customWantsCondiments()
	 */
	@Override
	protected boolean customWantsCondiments() {
		return false;
	}

}
