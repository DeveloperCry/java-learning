/**
 * 
 */
package com.learning.spring.bean;

/**
 * @author Xiong.Liu
 *
 */
public class TestBean {
	
	private TestBean spouse;
	private String country;

	public TestBean() {
		
	}
	
	public TestBean(String str) {
		System.out.println(str);
	}
	
	public TestBean(String str, int i) {
		System.out.println(str + i);
	}

	
	/**
	 * Gets spouse
	 * @return the spouse
	 */
	public TestBean getSpouse() {
		return spouse;
	}

	
	/**
	 * Sets spouse the spouse
	 * @param spouse the spouse to set
	 */
	public void setSpouse(TestBean spouse) {
		this.spouse = spouse;
	}

	
	/**
	 * Gets country
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	
	/**
	 * Sets country the country
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
}
