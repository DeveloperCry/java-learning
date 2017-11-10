/**
 * 
 */
package com.learning.mode.single.thread;

import com.learning.mode.single.LazySingle;

/**
 * @author Xiong.Liu
 *
 */
public class LazyThread implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println(LazySingle.getInstance());
		
	}

}
