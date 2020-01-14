/**
 * 
 */
package learning.mode.factory.simple;

/**
 * @author Xiong.Liu
 *
 */
public abstract class Vehicle {
	public void run() {
		System.out.println("The car can run.");
	}
	
	public abstract void fly();
	
	public abstract void swim();
}
