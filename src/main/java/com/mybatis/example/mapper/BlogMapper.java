package com.mybatis.example.mapper;

import org.apache.ibatis.annotations.Select;

import com.mybatis.example.enity.Blog;

public interface BlogMapper {
	
	@Select("SELECT * FROM BLOG WHERE ID = #{id}")
	public Blog selectBlog(int id);
	
	public Blog selectBlogByName(String name);

}
