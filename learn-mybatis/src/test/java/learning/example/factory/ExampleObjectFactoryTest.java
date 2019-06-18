/**
 * 
 */
package learning.example.factory;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.example.enity.Blog;
import com.mybatis.example.enity.User;

/**
 * @author Xiong.Liu
 *
 */
public class ExampleObjectFactoryTest {

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
	public void setPropertiesTest() {
		SqlSessionFactory factory = SqlSessionFactories.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		session.close();
		assertNotNull(session);
	}
	
	@Test
	public void createTest() {
		SqlSession session = null;
		try {
			SqlSessionFactory factory = SqlSessionFactories.getSqlSessionFactory();
			session = factory.openSession();
			
			ExampleObjectFactory exampleObjectFactory = new ExampleObjectFactory();
			
			User user = (User)exampleObjectFactory.create(User.class);
			assertNotNull(user);
			System.out.println(user.toString());
			
			Blog blog = (Blog) exampleObjectFactory.create(Blog.class);
			System.out.println(blog.toString());
		} finally {
			session.close();
		}
	}

}
