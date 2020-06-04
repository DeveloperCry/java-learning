/**
 * 
 */
package com.learning.spring.service.impl;

/**
 * @author Xiong.Liu
 *
 */
public class ClientService {
	
	private static ClientService clientService = null;
	
	public ClientService() {
		super();
	}

	public static ClientService createInstance() {
		if (clientService == null) {
			clientService = new ClientService();
		}
		System.out.println("createInstance is called");
		return clientService;
	}

}
