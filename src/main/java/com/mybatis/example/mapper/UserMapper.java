package com.mybatis.example.mapper;

import org.apache.ibatis.annotations.Select;

import com.mybatis.example.enity.User;

public interface UserMapper {
	
	@Select("SELECT * FROM USER WHERE ID = #{id}")
	public User selectUser(int id);
	
//	public Blog selectBlogByName(String name);

}
