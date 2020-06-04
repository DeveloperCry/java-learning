/**
 * 
 */
package com.learning.spring.bean;

import org.springframework.stereotype.Repository;

/**
 * @author Xiong.Liu
 *
 */
@Repository
public class JpaMovieFinder implements MovieFinder{

	/* (non-Javadoc)
	 * @see MovieFinder#finder()
	 */
	@Override
	public void finder() {
		// TODO Auto-generated method stub
		System.out.println("This is a JpaMovieFinder");
	}
	
}
