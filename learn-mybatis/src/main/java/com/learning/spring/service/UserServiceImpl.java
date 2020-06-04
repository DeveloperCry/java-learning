/**
 * 
 */
package com.learning.spring.service;

import com.learning.spring.enity.User;
import com.learning.spring.mapper.UserMapper;

/**
 * @author Xiong.Liu
 *
 */
public class UserServiceImpl implements UserService {
	
	private UserMapper userMapper;

	
	/**
	 * Sets userMapper the userMapper
	 * @param userMapper the userMapper to set
	 */
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	public User getUserById(Integer id) {
		return this.userMapper.getUser(id);
	}
}
