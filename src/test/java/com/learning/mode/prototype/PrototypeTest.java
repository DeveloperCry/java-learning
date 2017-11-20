/**
 * 
 */
package com.learning.mode.prototype;

import org.junit.Test;

/**
 * @author Milier
 *
 */
public class PrototypeTest {

	@Test
	public void testPrototype() {
		ConcretePrototype prototype = new ConcretePrototype();
		
		for (int i = 0; i < 10; i++) {
			ConcretePrototype clonePrototype = (ConcretePrototype)prototype.clone();
			
			clonePrototype.show();
		}
	}
	
	/**
	 * ǳ��������
	 */
	@Test
	public void testThing() {
		Thing thing = new Thing();
		
		thing.setList("1234567890");
		
		Thing cloneThing = thing.clone();
		cloneThing.setList("qwertyuiop");
		System.out.println(thing.getList());
	}
	
	/**
	 * �������
	 */
	@Test
	public void testDeepThing() {
		DeepThing thing = new DeepThing();
		System.out.println(thing.hashCode());
//		thing.setList("12345678900");//ע�⸳ֵ��˳���ȸ�ֵ�󿽱���Ҳ�Ὣ��ֵ������ȥ����֮����û��
		
		DeepThing cloneThing = thing.clone();
		
		thing.setList("12345678900");
		System.out.println(cloneThing.hashCode());
		cloneThing.setList("qwertyuiop1");
		System.out.println(thing.getList());
		System.out.println(cloneThing.getList());
	}

}
