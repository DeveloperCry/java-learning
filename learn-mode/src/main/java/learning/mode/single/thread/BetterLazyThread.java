/**
 * 
 */
package learning.mode.single.thread;

import learning.mode.single.BetterLazySingle;

/**
 * @author Xiong.Liu
 *
 */
public class BetterLazyThread implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(BetterLazySingle.getInstance());
		
	}

}