/**
 * 
 */
package learning.mode.command;

import learning.mode.command.command.Command;

/**
 * @author Milier
 *
 *����ģʽ���ŵ㣺
 *�� ������
 *�����߽�ɫ������߽�ɫ֮��û���κ�������ϵ��������ʵ�ֹ���ʱֻ�����Command�������execute�����Ϳ��ԣ�����Ҫ�˽⵽�����ĸ�������ִ�С�
 *�� ����չ��
 *Command��������Էǳ����׵���չ����������Invoker�͸߲�ε�ģ��Client���������صĴ�����ϡ�
 *�� ����ģʽ�������ģʽ�������
 *����ģʽ���Խ��������ģʽ��ʵ��������������񣻽��ģ�巽��ģʽ������Լ���Command������������⡣
 *
 *ȱ�㣺Command�������������͵����⡣
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
