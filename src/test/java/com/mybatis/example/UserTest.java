/**
 * 
 */
package com.mybatis.example;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
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
	
//	@Test
	public void addUserTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			UserMapper userMapper = (UserMapper)sqlSession.getMapper(UserMapper.class);
			
			User user = new User();
			user.setName("jeck010");
			user.setAge(19);
			user.setPhoneNumber("1234567899");
			user.setAddress("chengdu, sichuan");
			user.setIdCard("1234567890123456789");
			user.setCreateDate(new Date());
			user.setEditDate(new Date());
			
			userMapper.addUser(user);
			sqlSession.commit();//must commit so that the data can store in database authentically
			System.out.println(user.toString());
			assertNotNull(user);
		} finally {
			sqlSession.close();
		}
	}
	
//	@Test
	public void addUserAndGeneratedKeysTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			UserMapper userMapper = (UserMapper)sqlSession.getMapper(UserMapper.class);
			
			User user = new User();
			user.setName("jeck011");
			user.setAge(19);
			user.setPhoneNumber("1234567899");
			user.setAddress("chengdu, sichuan");
			user.setIdCard("1234567890123456789");
			user.setCreateDate(new Date());
			user.setEditDate(new Date());
			
			//useGeneratedKeys and keyProperty should be used together, by this way,  the id(primary key) can be returned.
			int id = userMapper.addUserAndGeneratedKeys(user);//id is the total record of update
			sqlSession.commit();//must commit so that the data can store in database authentically
			assertFalse(id == 0);
			System.out.println(id);
			System.out.println(user.toString());
			assertNotNull(user);
		} finally {
			sqlSession.close();
		}
	}
	
//	@Test
	public void addUsersTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			List<User> users = new ArrayList<User>();
			
			UserMapper userMapper = (UserMapper)sqlSession.getMapper(UserMapper.class);
			
			User user = new User();
			user.setName("jeck012");
			user.setAge(19);
			user.setPhoneNumber("1234567899");
			user.setAddress("chengdu, sichuan");
			user.setIdCard("1234567890123456789");
			user.setCreateDate(new Date());
			user.setEditDate(new Date());
			users.add(user);
			
			User user2 = new User();
			user2.setName("jeck013");
			user2.setAge(19);
			user2.setPhoneNumber("1234567899");
			user2.setAddress("chengdu, sichuan");
			user2.setIdCard("1234567890123456789");
			user2.setCreateDate(new Date());
			user2.setEditDate(new Date());
			users.add(user2);
			
			
			//useGeneratedKeys and keyProperty should be used together, by this way,  the id(primary key) can be returned.
			int count = userMapper.addUsers(users);//id is the total record of update
			sqlSession.commit();//must commit so that the data can store in database authentically
			assertFalse(count == 0);
			System.out.println(count);
			for (User user3 : users) {
				System.out.println(user3.toString());
			}
			assertNotNull(CollectionUtils.isNotEmpty(users));
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void updateUserByNameTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			UserMapper userMapper = (UserMapper)sqlSession.getMapper(UserMapper.class);
			
//			User user = userMapper.selectUser("");
			
			User user = new User();
			user.setName("jeck009");
			user.setAddress("neijiang, sichuan");
			
			int count = userMapper.updateUserByName(user);//should included in user
			sqlSession.commit();//must commit so that the data can store in database authentically
			assertFalse(count == 0);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
//	@Test
	public void deleteUserByNameTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			UserMapper userMapper = (UserMapper)sqlSession.getMapper(UserMapper.class);
			int count = userMapper.deleteUserByName("jeck011");
			sqlSession.commit();//must commit so that the data can store in database authentically
			assertFalse(count == 0);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
//	@Test
	public void deleteUserByNameAndAddressTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			UserMapper userMapper = (UserMapper)sqlSession.getMapper(UserMapper.class);
			int count = userMapper.deleteUserByNameAndAddress("jeck010", "chengdu, sichuan");
			sqlSession.commit();//must commit so that the data can store in database authentically
			assertFalse(count == 0);
			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	@Test
	public void selectUserByNameTest() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();
			
			UserMapper userMapper = (UserMapper)sqlSession.getMapper(UserMapper.class);
			User user = userMapper.selectUserByName("jeck010");
			assertFalse(user == null);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Test failed");
		} finally {
			sqlSession.close();
		}
	}

}