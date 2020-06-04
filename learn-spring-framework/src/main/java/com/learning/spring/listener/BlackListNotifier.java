/**
 * 
 */
package com.learning.spring.listener;

import org.springframework.context.ApplicationListener;

import com.learning.spring.event.BlackListEvent;

/**
 * @author Xiong.Liu
 *
 */
public class BlackListNotifier implements ApplicationListener<BlackListEvent>{

	private String notificationAddress;
	
	/**
	 * Sets notificationAddress the notificationAddress
	 * @param notificationAddress the notificationAddress to set
	 */
	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}
	
	@Override
	public void onApplicationEvent(BlackListEvent event) {
		System.out.println("I am the Black List Event start");
		System.out.println(event.getAddress());
		System.out.println(event.getText());
		System.out.println("I am the Black List Event end");
	}

}
