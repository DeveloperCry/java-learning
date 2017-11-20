/**
 * 
 */
package com.learning.mode.proxy;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Milier
 *
 */
public class ProxyTest {

	@Test
	public void testProxy() {
		ProxySubject proxySubject = new ProxySubject();
		
		proxySubject.request();
	}

}
