/**
 * 
 */
package com.mybatis.example;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.example.enity.Blog;
import com.mybatis.example.enity.Page;
import com.mybatis.example.factory.SqlSessionFactories;
import com.mybatis.example.mapper.BlogMapper;

/**
 * @author Xiong.Liu
 *
 */
public class PageTest {

	SqlSessionFactory sessionFactory = null;
	@Before
	public void setUp() throws Exception {
		sessionFactory = SqlSessionFactories.getSqlSessionFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void pagesTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sessionFactory.openSession();
			BlogMapper mapper = (BlogMapper)sqlSession.getMapper(BlogMapper.class);
			Page<Blog> page = new Page<Blog>();
			page.setPageNo(3);
			
			List<Blog> blogs = mapper.findBlog(page);
			assertTrue(CollectionUtils.isNotEmpty(blogs));
			page.setResults(blogs);
			System.out.println(page);
			for (Blog blog : page.getResults()) {
				System.out.println(blog);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("This testing is failed.");
		} finally {
			sqlSession = null;
		}
	}

}
