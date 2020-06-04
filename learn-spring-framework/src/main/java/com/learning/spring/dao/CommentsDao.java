/**
 * 
 */
package com.learning.spring.dao;

/**
 * @author Xiong.Liu
 *
 */
public class CommentsDao {
	
	public String printComments(String comment) {
		String outComment = "This is comments dao: " + comment;
		return outComment;
	}

}
