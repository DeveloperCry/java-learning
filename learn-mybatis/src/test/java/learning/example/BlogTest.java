/**
 * 
 */
package learning.example;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import learning.example.enity.Blog;
import learning.example.factory.SqlSessionFactories;
import learning.example.mapper.BlogMapper;

/**
 * @author Xiong.Liu
 *
 */
public class BlogTest {
	
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void setUp() throws Exception {
		sqlSessionFactory = SqlSessionFactories.getSqlSessionFactory();
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void NoXMLMapperTest() {
		
		SqlSession sqlSession = null;
		try{
			sqlSession = SqlSessionFactories.getSqlSessionFactory().openSession();
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			Blog blog = blogMapper.selectBlog(2);
			System.out.println(blog);
//			fail("Not yet implemented");
			Assert.assertNotNull(blog);
			
		} finally {
			sqlSession.close();
		}
		
	}
	
	@Test
	public void XMLMapperTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = SqlSessionFactories.getSqlSessionFactory().openSession();
			Blog blog = (Blog) sqlSession.selectOne("BlogMapper.selectBlogByName", "GOOD JOB2");
			System.out.println(blog);
			Assert.assertNotNull(blog);
		} 
		finally {
			sqlSession.close();
		}
		
	}
	
	@Test
	public void findActiveBlogWithNameLikeTest() {
		System.out.println("test findActiveBlogWithNameLike start.........");
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			List<Blog> blogs = mapper.findActiveBlogWithNameLike("1");
			Assert.assertTrue(CollectionUtils.isNotEmpty(blogs));
			System.out.println(blogs.size());
			for (Blog blog : blogs) {
				System.out.println(blog);
			}
			System.out.println(blogs.size());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("This test failed.");
		} finally {
			sqlSession.close();
		}
		System.out.println("test findActiveBlogWithNameLike end.........");
	}
	
	@Test
	public void findActiveBlogLikeTest() {
		
		System.out.println("test findActiveBlogLike start.........");
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			List<Blog> blogs = mapper.findActiveBlogLike("good", null);
			Assert.assertTrue(CollectionUtils.isNotEmpty(blogs));
			System.out.println(blogs.size());
			for (Blog blog : blogs) {
				System.out.println(blog);
			}
			System.out.println(blogs.size());
			System.out.println("=====================");
			
			Blog pblog = new Blog();
			pblog.setTitle("a");
			List<Blog> blogs2 = mapper.findActiveBlogLike(null, pblog);
			Assert.assertTrue(CollectionUtils.isNotEmpty(blogs2));
			System.out.println(blogs2.size());
			for (Blog blog : blogs2) {
				System.out.println(blog);
			}
			System.out.println(blogs2.size());
			
			System.out.println("=====================");
			
			List<Blog> blogs3 = mapper.findActiveBlogLike(null, null);
			Assert.assertTrue(CollectionUtils.isNotEmpty(blogs3));
			System.out.println(blogs3.size());
			for (Blog blog : blogs3) {
				System.out.println(blog);
			}
			System.out.println(blogs3.size());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("This test failed.");
		} finally {
			sqlSession.close();
		}
		System.out.println("test findActiveBlogLike end.........");
	}
	
	@Test
	public void findBlogWithStatusTest() {
		
		System.out.println("test findBlogWithStatus start.........");
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			List<Blog> blogs = mapper.findBlogWithStatus("ACTIVE", null);
			Assert.assertTrue(CollectionUtils.isNotEmpty(blogs));
			System.out.println(blogs.size());
			for (Blog blog : blogs) {
				System.out.println(blog);
			}
			System.out.println(blogs.size());
			System.out.println("=====================");
			
			List<Blog> blogs2 = mapper.findBlogWithStatus(null, "a");
			Assert.assertTrue(CollectionUtils.isNotEmpty(blogs2));
			System.out.println(blogs2.size());
			for (Blog blog : blogs2) {
				System.out.println(blog);
			}
			System.out.println(blogs2.size());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("This test failed.");
		} finally {
			sqlSession.close();
		}
		System.out.println("test findBlogWithStatus end.........");
	}
	
	@Test
	public void selectBlogWithUserTest() {
		
		System.out.println("\n test selectBlogWithUser start.........\n");
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			Blog blog = mapper.selectBlogWithUser(2);
			Assert.assertFalse(blog == null);
			Assert.assertFalse(blog.getUser() == null);
			System.out.println(blog);
			System.out.println(blog.getUser());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("This test failed.");
		} finally {
			sqlSession.close();
		}
		System.out.println("\n test selectBlogWithUser end.........\n");
	}
	
	@Test
	public void selectBlogWithUser2Test() {
		
		System.out.println("\n test selectBlogWithUser2 start.........\n");
		SqlSession sqlSession = null;
		
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
			Blog blog = mapper.selectBlogWithUser2(3);
			Assert.assertFalse(blog == null);
			Assert.assertFalse(blog.getUser() == null);
			System.out.println(blog);
			System.out.println(blog.getUser());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("This test failed.");
		} finally {
			sqlSession.close();
		}
		System.out.println("\n test selectBlogWithUser2 end.........\n");
	}
}
