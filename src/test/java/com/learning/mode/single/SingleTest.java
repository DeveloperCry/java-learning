/**
 * 
 */
package com.learning.mode.single;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.learning.mode.single.thread.BetterLazyThread;
import com.learning.mode.single.thread.LazyThread;

/**
 * @author Xiong.Liu
 *
 */
public class SingleTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHungrySingle() {
		System.out.println("hungry single start");
		for (int i = 0; i < 5; i++) {
			System.out.println(HungrySingle.getInstance());
		}
		System.out.println("hungry single end");
	}
	
	@Test
	public void testLazySingle() {
		System.out.println("lazy single start");
		for (int i = 0; i < 3; i++) {
			System.out.println(LazySingle.getInstance());
		}
		System.out.println("lazy single end");
	}
	
	@Test
	public void testThreadLazySingle() {
		System.out.println("thread lazy single start");
		LazyThread lazyThread = new LazyThread();
		Thread thread1 = new Thread(lazyThread);
		Thread thread2 = new Thread(lazyThread);
		thread1.start();
		thread2.start();
		System.out.println("thread lazy single end");
	}
	
	@Test
	public void testBetterLazySingle() {
		System.out.println("better lazy single start");
		for (int i = 0; i < 3; i++) {
			System.out.println(BetterLazySingle.getInstance());
		}
		System.out.println("better lazy single end");
	}
	
	@Test
	public void testBetterThreadLazySingle() {
		System.out.println("better thread lazy single start");
		BetterLazyThread lazyThread = new BetterLazyThread();
		Thread thread1 = new Thread(lazyThread);
		Thread thread2 = new Thread(lazyThread);
		thread1.start();
		thread2.start();
		System.out.println("better thread lazy single end");
	}

}
