/**
 * 
 */
package com.learning.mode.single;

/**
 * @author Xiong.Liu
 * 多线程环境下的懒汉式单例模式(基于静态内部类实现)
 * 这样可以在不实例化的时候不产生开销
 */
public class InnerSingle {
	private InnerSingle() {}
	private static class Inner {
		final static InnerSingle SINGLE = new InnerSingle();
	}
	
	public static InnerSingle getInstance() {
		return Inner.SINGLE;
	}
}
