/**
 * 
 */
package com.spring.framework.example.bean;

import org.springframework.stereotype.Repository;

/**
 * @author Xiong.Liu
 *
 */
@Repository
public class JpaMovieFinder implements MovieFinder{

	/* (non-Javadoc)
	 * @see com.spring.framework.example.bean.MovieFinder#finder()
	 */
	@Override
	public void finder() {
		// TODO Auto-generated method stub
		System.out.println("This is a JpaMovieFinder");
	}
	
}
