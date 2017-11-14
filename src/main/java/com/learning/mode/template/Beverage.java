/**
 * 
 */
package com.learning.mode.template;

/**
 * @author Xiong.Liu
 * 使用模板方法模式可以将代码的公共行为提取，以达到复用的目的。
 * 而对于特殊化的行为在子类中实现。父类的模板方法可以控制子类中的具体实现。
 * 子类无需了解整体算法框架，只需实现自己的业务逻辑即可。 
 */
public abstract class Beverage {
	protected void boidWater() {
		System.out.println("Boid water.");
	}
	
	protected void pourInCup() {
		System.out.println("Pour water into cup.");
	}
	
	protected boolean customWantsCondiments() {
		return true;
	}
	
	protected abstract void brew();
	
	protected abstract void addCondiments();
	
	public void prepareBeverage() {
		this.boidWater();
		this.brew();
		this.pourInCup();
		if (this.customWantsCondiments()) {
			this.addCondiments();
		}
	}
}
