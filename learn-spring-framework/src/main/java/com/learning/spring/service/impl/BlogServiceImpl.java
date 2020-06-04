/**
 * 
 */
package com.learning.spring.service.impl;

import com.learning.spring.service.BlogService;
import com.learning.spring.dao.BlogDao;
import com.learning.spring.dao.CommentsDao;

/**
 * @author Xiong.Liu
 *
 */
public class BlogServiceImpl implements BlogService {
	private BlogDao blogDao;
	private CommentsDao commentsDao;
	
//	/**
//	 * Gets blogDao
//	 * @return the blogDao
//	 */
//	public BlogDao getBlogDao() {
//		return blogDao;
//	}
	
	/**
	 * Sets blogDao the blogDao
	 * @param blogDao the blogDao to set
	 */
	public void setBlogDao(BlogDao blogDao) {
		this.blogDao = blogDao;
	}
	
//	/**
//	 * Gets commentsDao
//	 * @return the commentsDao
//	 */
//	public CommentsDao getCommentsDao() {
//		return commentsDao;
//	}
	
	/**
	 * Sets commentsDao the commentsDao
	 * @param commentsDao the commentsDao to set
	 */
	public void setCommentsDao(CommentsDao commentsDao) {
		this.commentsDao = commentsDao;
	}
	
	
	public void getBlog() {
		System.out.println(blogDao.printBlog("Liu Xiong"));
		System.out.println(commentsDao.printComments("Good Work"));
	}
	
}
