/**
 * 
 */
package com.learning.mode.command;

import com.learning.mode.command.command.Command;

/**
 * @author Milier
 *
 *命令模式的优点：
 *● 类间解耦
 *调用者角色与接收者角色之间没有任何依赖关系，调用者实现功能时只需调用Command抽象类的execute方法就可以，不需要了解到底是哪个接收者执行。
 *● 可扩展性
 *Command的子类可以非常容易地扩展，而调用者Invoker和高层次的模块Client不产生严重的代码耦合。
 *● 命令模式结合其他模式会更优秀
 *命令模式可以结合责任链模式，实现命令族解析任务；结合模板方法模式，则可以减少Command子类的膨胀问题。
 *
 *缺点：Command的子类会产生膨胀的问题。
 */
public class Invoker {
	private Command command;
	
	/**
	 * @param command the command to set
	 */
	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void action() {
		this.command.execute();
	}
}
