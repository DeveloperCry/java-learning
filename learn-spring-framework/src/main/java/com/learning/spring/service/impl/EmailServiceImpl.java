/**
 * 
 */
package com.learning.spring.service.impl;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

import com.learning.spring.event.BlackListEvent;


/**
 * @author Xiong.Liu
 *
 */
@Service
public class EmailServiceImpl implements ApplicationEventPublisherAware{

	private List<String> blackList;
	private ApplicationEventPublisher publisher;
	
	
	/**
	 * Sets blackList the blackList
	 * @param blackList the blackList to set
	 */
	public void setBlackList(List<String> blackList) {
		this.blackList = blackList;
	}
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
	
	public void sendEamil(String address, String text) {
		if (blackList.contains(address)) {
			BlackListEvent event = new BlackListEvent(this, address, text);
			publisher.publishEvent(event);
			return;
		}
	}
	
}
