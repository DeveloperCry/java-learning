/**
 * 
 */
package com.spring.framework.example.lister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.framework.example.bean.MovieFinder;

/**
 * @author Xiong.Liu
 *
 */
@Service
public class SimpleMovieLister {
	private MovieFinder movieFinder;
	
	@Autowired
	public SimpleMovieLister(MovieFinder movieFinder) {
		this.movieFinder = movieFinder;
		System.out.println("There is SimpleMovieLister");
	}
	
	public void printMovie() {
		System.out.println("Print Movie");
		movieFinder.finder();
	}
}
