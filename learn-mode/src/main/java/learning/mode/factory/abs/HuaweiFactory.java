/**
 * 
 */
package learning.mode.factory.abs;

/**
 * @author Xiong.Liu
 *
 */
public class HuaweiFactory implements ElectronicFactory{

	/* (non-Javadoc)
	 * @see ElectronicFactory#produceComputer()
	 */
	@Override
	public Computer produceComputer() {
		return new HuaweiComputer();
	}

	/* (non-Javadoc)
	 * @see ElectronicFactory#produceTelephone()
	 */
	@Override
	public Telephone produceTelephone() {
		return new HuaweiTelephone();
	}

}
