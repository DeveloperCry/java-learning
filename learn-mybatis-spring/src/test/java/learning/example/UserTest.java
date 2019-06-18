/**
 * 
 */
package learning.example;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import learning.example.enity.User;
import learning.example.mapper.UserMapper;

/**
 * @author Xiong.Liu
 *
 */
public class UserTest extends BaseTest{
	
	@Autowired
	private UserMapper userMapper;

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
		User user = userMapper.getUser(1);
		Assert.assertNotNull(user);
		System.out.println(user.toString());
	}

}
