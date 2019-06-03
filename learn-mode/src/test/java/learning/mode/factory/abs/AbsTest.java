/**
 * 
 */
package learning.mode.factory.abs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Xiong.Liu
 *
 */
public class AbsTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		ElectronicFactory factory = new HuaweiFactory();
		Telephone phone = factory.produceTelephone();
		System.out.println(phone.getProductInfo());
		Computer computer = factory.produceComputer();
		System.out.println(computer.getProductInfo());
	}

}
