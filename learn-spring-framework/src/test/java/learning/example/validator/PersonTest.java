/**
 * 
 */
package learning.example.validator;

import learning.BaseTest;
import learning.example.bean.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Xiong.Liu
 *
 */
public class PersonTest extends BaseTest {

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
	public void personInfoTest() {
		Person person = new Person();
		person.setAge(120);
	}

}
