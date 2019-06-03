/**
 * 
 */
package learning.mode.factory.abs;

/**
 * @author Xiong.Liu
 *
 */
public class HuaweiTelephone implements Telephone{

	/* (non-Javadoc)
	 * @see Telephone#getProductInfo()
	 */
	@Override
	public String getProductInfo() {
		return "The hua wei is using the ANDROID.";
	}
	
}
