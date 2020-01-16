/**
 * 
 */
package learning.example.aspect;

import learning.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Xiong.Liu
 *
 */
//@Aspect
public class SystemArchitectureTest extends BaseTest {
	
	@Autowired
	private SystemArchitecture systemArchitecture;

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
		systemArchitecture.businessService();
	}

}
