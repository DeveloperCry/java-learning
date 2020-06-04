package com.learning.spring.mapper;

import java.util.List;

import com.learning.spring.enity.Page;
import com.learning.spring.enity.Blog;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BlogMapper {
	
	@Select("SELECT * FROM BLOG WHERE ID = #{id}")
	public Blog selectBlog(int id);
	
	public Blog selectBlogByName(String name);
	
	@Select("SELECT * FROM BLOG")
	public List<Blog> findBlog(Page<Blog> page);
	
	public List<Blog> findActiveBlogWithNameLike(@Param("name") String name);
	
	public List<Blog> findActiveBlogLike(@Param("name") String name, @Param("blog") Blog blog);
	
	public List<Blog> findBlogWithStatus(@Param("status") String status, @Param("title") String title);
	
	public Blog selectBlogWithUser(int id);
	
	public Blog selectBlogWithUser2(int id);

}
