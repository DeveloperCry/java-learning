/**
 * 
 */
package com.mybatis.example;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.example.enity.Blog;
import com.mybatis.example.factory.SqlSessionFactories;
import com.mybatis.example.mapper.BlogMapper;

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
			Blog blog = (Blog) sqlSession.selectOne("com.mybatis.example.mapper.BlogMapper.selectBlogByName", "GOOD JOB2");
			System.out.println(blog);
			Assert.assertNotNull(blog);
		} 
		finally {
			sqlSession.close();
		}
		
	}
	
	@Test
	public void findActiveBlogWithNameLikeTest() {
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
	}

}
