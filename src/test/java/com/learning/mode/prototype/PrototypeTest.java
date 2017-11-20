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
	 * 浅拷贝机制
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
	 * 深拷贝机制
	 */
	@Test
	public void testDeepThing() {
		DeepThing thing = new DeepThing();
		System.out.println(thing.hashCode());
//		thing.setList("12345678900");//注意赋值的顺序，先赋值后拷贝，也会将赋值拷贝过去，反之，则没有
		
		DeepThing cloneThing = thing.clone();
		
		thing.setList("12345678900");
		System.out.println(cloneThing.hashCode());
		cloneThing.setList("qwertyuiop1");
		System.out.println(thing.getList());
		System.out.println(cloneThing.getList());
	}

}
