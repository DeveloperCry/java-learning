/**
 * 
 */
package learning.mode.factory.abs;

/**
 * @author Xiong.Liu
 *
 */
public class AppleFactory implements ElectronicFactory{

	/* (non-Javadoc)
	 * @see ElectronicFactory#produceComputer()
	 */
	@Override
	public Computer produceComputer() {
		return new AppleComputer();
	}

	/* (non-Javadoc)
	 * @see ElectronicFactory#produceTelephone()
	 */
	@Override
	public Telephone produceTelephone() {
		return new AppleTelephone();
	}

}
