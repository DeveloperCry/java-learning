/**
 * 
 */
package com.learning.spring.dao;

/**
 * @author Xiong.Liu
 *
 */
public class BlogDao {

	public String printBlog(String blog) {
		String outblog = "This is blog dao: " + blog;
		return outblog;
	}

}
