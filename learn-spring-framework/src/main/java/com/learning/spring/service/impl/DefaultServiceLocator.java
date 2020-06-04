package com.learning.spring.service.impl;

public class DefaultServiceLocator {
	private static ClientService clientService = new ClientService();

	public DefaultServiceLocator() { }
	
	public ClientService createClientServiceInstance(){
		System.out.println("There is createClientServiceInstance");
		return clientService;
	}
}
