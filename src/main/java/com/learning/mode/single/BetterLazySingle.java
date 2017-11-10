/**
 * 
 */
package com.learning.mode.single;

/**
 * @author Xiong.Liu
 * 解决了在多线程中出现的问题
 * 对比直接在方法上加同步，如果synchronized方法，那么每次调用的时候都会锁住，这是没有必要的
 */
public class BetterLazySingle {
	private static BetterLazySingle single = null;

	private BetterLazySingle() {
	}
	
	public static BetterLazySingle getInstance() {
		
		if (single == null) {
			synchronized (BetterLazySingle.class) {
				if (single == null) {
					single = new BetterLazySingle();
				}
			}
		}
		
		return single;
	}
	
}
