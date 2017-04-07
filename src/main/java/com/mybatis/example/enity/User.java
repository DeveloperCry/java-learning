package com.mybatis.example.enity;

import java.util.Date;

public class User {
	
	private int id;
	private String name;
	private int age;
	private String address;
	private String phoneNumber;
	private String idCard;
	private Date createDate;
	private Date editDate;
	
	/**
	 * Gets id
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Sets id the id
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Gets name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Sets name the name
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets age
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * Sets age the age
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * Gets address
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Sets address the address
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Gets phoneNumber
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Sets phoneNumber the phoneNumber
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * Gets idCard
	 * @return the idCard
	 */
	public String getIdCard() {
		return idCard;
	}
	/**
	 * Sets idCard the idCard
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	/**
	 * Gets createDate
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * Sets createDate the createDate
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * Gets editDate
	 * @return the editDate
	 */
	public Date getEditDate() {
		return editDate;
	}
	/**
	 * Sets editDate the editDate
	 * @param editDate the editDate to set
	 */
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", idCard=" + idCard + ", createDate=" + createDate + ", editDate=" + editDate + "]";
	}
	
}
