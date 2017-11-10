/**
 * 
 */
package com.learning.mode.single;

/**
 * @author Xiong.Liu
 *
 *饿汉式
 */
public class HungrySingle {
	private static final HungrySingle SINGLE = new HungrySingle();
	
	private HungrySingle() {}

	public static HungrySingle getInstance() {
		return SINGLE;
	}
}
