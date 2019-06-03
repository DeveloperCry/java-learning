/**
 * 
 */
package learning.mode.single;

/**
 * @author Xiong.Liu
 *
 *懒汉式(实例延迟加载的单例模式)
 *缺点： 单线程执行时可以，多线程时会出现线程安全问题
 */
public class LazySingle {

	private static LazySingle single= null;
	
	private LazySingle() {}
	
	public static LazySingle getInstance() {
		if (single == null) {
			single = new LazySingle();
		}
		return single;
	}
}
