/**
 * 
 */
package com.learning.mode.proxy;

/**
 * @author Milier
 *
 */
public class ProxySubject extends Subject{
	private RealSubject realSubject;

	/* (non-Javadoc)
	 * @see com.learning.mode.proxy.Subject#request()
	 */
	@Override
	public void request() {
		if (realSubject == null) {
			realSubject = new RealSubject();
		}
		System.out.println("This is the proxy begin");
		realSubject.request();
		System.out.println("This is the proxy end");
	}
	
	
}
