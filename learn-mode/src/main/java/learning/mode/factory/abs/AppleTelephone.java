/**
 * 
 */
package learning.mode.factory.abs;

/**
 * @author Xiong.Liu
 *
 */
public class AppleTelephone implements Telephone{

	/* (non-Javadoc)
	 * @see Telephone#getProductInfo()
	 */
	@Override
	public String getProductInfo() {
		return "The apple is using the IOS.";
	}

}
