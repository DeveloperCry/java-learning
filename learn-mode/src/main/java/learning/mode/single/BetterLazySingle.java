/**
 * 
 */
package learning.mode.single;

/**
 * @author Xiong.Liu
 * 解决了在多线程中出现的问题
 * 对比直接在方法上加同步，如果synchronized方法，那么每次调用的时候都会锁住，这是没有必要的
 * 什么是指令重排序：是指CPU采用了允许将多条指令不按程序规定的顺序分开发送给各相应电路单元处理
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
