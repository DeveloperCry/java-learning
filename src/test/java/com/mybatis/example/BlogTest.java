/**
 * 
 */
package com.mybatis.example;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import com.mybatis.example.enity.Blog;
import com.mybatis.example.factory.SqlSessionFactories;
import com.mybatis.example.mapper.BlogMapper;

/**
 * @author Xiong.Liu
 *
 */
public class BlogTest {
	
	@Test
	public void NoXMLMapperTest() {
		
		SqlSession sqlSession = null;
		try{
			sqlSession = SqlSessionFactories.getSqlSessionFactory().openSession();
			BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
			Blog blog = blogMapper.selectBlog(2);
			System.out.println(blog.getContent());
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
			System.out.println(blog.getId());
			Assert.assertNotNull(blog);
		} 
		finally {
			sqlSession.close();
		}
		
	}

}
