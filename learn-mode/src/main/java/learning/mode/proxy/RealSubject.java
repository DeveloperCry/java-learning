/**
 * 
 */
package learning.mode.proxy;

/**
 * @author Milier
 *
 */
public class RealSubject extends Subject{

	/* (non-Javadoc)
	 * @see Subject#request()
	 */
	@Override
	public void request() {
		System.out.println("This is the real subject");
		
	}
	
}