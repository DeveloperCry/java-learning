/**
 * 
 */
package com.mybatis.example;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.mybatis.example.enity.User;
import com.mybatis.example.factory.SqlSessionFactories;
import com.mybatis.example.mapper.UserMapper;

/**
 * @author Xiong.Liu
 *
 */
public class UserTest {
	
	private SqlSessionFactory sqlSessionFactory = null;
	
	@Before
	public void setUp() throws Exception {
		sqlSessionFactory = SqlSessionFactories.getSqlSessionFactory();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void getUserTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			UserMapper userMapper = (UserMapper)sqlSession.getMapper(UserMapper.class);
			User user = (User)userMapper.selectUser(3);
			System.out.println(user.toString());
			assertNotNull(user);
		} finally {
			sqlSession.close();
		}
	}

}
