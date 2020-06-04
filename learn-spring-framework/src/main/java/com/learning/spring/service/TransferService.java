/**
 * 
 */
package com.learning.spring.service;

/**
 * @author Xiong.Liu
 *
 */
public interface TransferService {
	public void transfer(float money, String address, String street);
	
	public void printDataSource();
}
