/**
 * 
 */
package learning.example.listener;

import learning.example.bean.MovieFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
