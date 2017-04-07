package com.mybatis.example.enity;

import java.util.Date;

public class Blog {
	
	private int id;
	private String name;
	private String content;
	private Date createDate;
	private int createUser;
	/** The name of property should be the same as database column*/
	private Date edit_date;
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
	 * Gets edit_date
	 * @return the edit_date
	 */
	public Date getEdit_date() {
		return edit_date;
	}
	
	/**
	 * Sets edit_date the edit_date
	 * @param edit_date the edit_date to set
	 */
	public void setEdit_date(Date edit_date) {
		this.edit_date = edit_date;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", content=" + content + ", createDate=" + createDate
				+ ", createUser=" + createUser + ", editDate=" + edit_date + ", editUser=" + editUser + "]";
	}
	
}
