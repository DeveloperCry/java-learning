/**
 * 
 */
package learning.example;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import learning.example.enity.Blog;
import learning.example.factory.SqlSessionFactories;
import learning.example.mapper.BlogMapper;

/**
 * @author Xiong.Liu
 *
 */
public class BlogOtherTest {

	private InputStream inputStream = null;
	private SqlSessionFactory sqlSessionFactory = null;
	public final String resource = "learning/example/conf/mybatis-config.xml";
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		SqlSession sqlSession = null;
		try{
			sqlSession = sqlSessionFactory.openSession();
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			Blog blog = blogMapper.selectBlog(2);
			System.out.println(blog.getContent());
//			fail("Not yet implemented");
			Assert.assertNotNull(blog);
			
		} finally {
			sqlSession.close();
		}
	}

}
