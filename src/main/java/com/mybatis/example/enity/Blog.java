package com.mybatis.example.enity;

import java.util.Date;

public class Blog {
	
	private int id;
	private String name;
	private String content;
	private Date createDate;
	private int createUser;
	private Date editDate;
	private int editUser;
	
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
	 * Gets content
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets content the content
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * Gets createUser
	 * @return the createUser
	 */
	public int getCreateUser() {
		return createUser;
	}
	
	/**
	 * Sets createUser the createUser
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(int createUser) {
		this.createUser = createUser;
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
	
	/**
	 * Gets editUser
	 * @return the editUser
	 */
	public int getEditUser() {
		return editUser;
	}
	
	/**
	 * Sets editUser the editUser
	 * @param editUser the editUser to set
	 */
	public void setEditUser(int editUser) {
		this.editUser = editUser;
	}
	
	
}
