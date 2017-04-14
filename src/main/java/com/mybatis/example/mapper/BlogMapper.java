package com.mybatis.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.mybatis.example.enity.Blog;
import com.mybatis.example.enity.Page;

public interface BlogMapper {
	
	@Select("SELECT * FROM BLOG WHERE ID = #{id}")
	public Blog selectBlog(int id);
	
	public Blog selectBlogByName(String name);
	
	@Select("SELECT * FROM BLOG")
	public List<Blog> findBlog(Page<Blog> page);
	
	public List<Blog> findActiveBlogWithNameLike(@Param("name") String name);

}
