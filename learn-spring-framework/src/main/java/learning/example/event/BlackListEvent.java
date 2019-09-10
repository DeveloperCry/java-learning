/**
 * 
 */
package learning.example.event;

import org.springframework.context.ApplicationEvent;

/**
 * @author Xiong.Liu
 *
 */
public class BlackListEvent extends ApplicationEvent{
	
	private static final long serialVersionUID = -3217038124243710789L;
	private final String address;
	private final String text;
	
	/**
	 * @param source
	 * @param address
	 * @param text
	 */
	public BlackListEvent(Object source, String address, String text) {
		super(source);
		this.address = address;
		this.text = text;
	}
	
	/**
	 * Gets address
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Gets text
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
}
