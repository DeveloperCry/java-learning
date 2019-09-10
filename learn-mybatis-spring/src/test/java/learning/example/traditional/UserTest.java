/**
 * 
 */
package learning.example.traditional;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import learning.example.enity.User;
import learning.example.mapper.UserMapper;

/**
 * @author Xiong.Liu
 *
 */
public class UserTest {

	public ApplicationContext ctx = null;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("learning/example/conf/applicationContext.xml");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		UserMapper userMapper = (UserMapper)ctx.getBean("userMapper");
		User user = userMapper.getUser(1);
		Assert.assertNotNull(user);
		System.out.println(user.toString());
	}

}
