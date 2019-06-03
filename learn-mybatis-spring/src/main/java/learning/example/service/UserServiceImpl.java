/**
 * 
 */
package learning.example.service;

import learning.example.enity.User;
import learning.example.mapper.UserMapper;

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
