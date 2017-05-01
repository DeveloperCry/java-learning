package com.spring.framework.example.service;

public class DefaultServiceLocator {
	private static ClientService clientService = new ClientService();

	public DefaultServiceLocator() { }
	
	public ClientService createClientServiceInstance(){
		System.out.println("There is createClientServiceInstance");
		return clientService;
	}
}
