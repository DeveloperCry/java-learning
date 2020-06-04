/**
 * 
 */
package com.learning.spring.bean;

/**
 * @author Xiong.Liu
 *
 */
public class Customer {
	private String firstName;
	private String secondName;
	private Address address;
	/**
	 * Gets firstName
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Sets firstName the firstName
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Gets secondName
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}
	/**
	 * Sets secondName the secondName
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	/**
	 * Gets address
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * Sets address the address
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
