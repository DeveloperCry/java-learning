/**
 * 
 */
package learning.example.service.impl;

import org.springframework.context.MessageSource;

/**
 * @author Xiong.Liu
 *
 */
public class MessageService {
	private MessageSource messageSource;

	
	/**
	 * Sets messageSource the messageSource
	 * @param messageSource the messageSource to set
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	public void execute() {
		String message = this.messageSource.getMessage("argument.required", new Object[]{"messageSource"}, "Error", null);
		System.out.println(message);
	}
}
