package com.learning.spring.mapper;

import java.util.List;

import com.learning.spring.enity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
	
	@Select("SELECT * FROM USER WHERE ID = #{id}")
	public User selectUser(int id);
	
//	public Blog selectBlogByName(String name);
	
	public void addUser(User user);
	
	public Integer addUserAndGeneratedKeys(User user);
	
	public Integer addUsers(List<User> users);
	
	public Integer updateUserByName(User user);
	
	public Integer deleteUserByName(String name);
	
	public Integer deleteUserByNameAndAddress(@Param("name") String name, @Param("address")  String address);
	
	public User selectUserByName(String name);
	
	public List<User> selectUserConstructor();
	
	public User selectUserWithBlog(int id);

}
