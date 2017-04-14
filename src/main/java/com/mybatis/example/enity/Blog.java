package com.mybatis.example.enity;

import java.util.Date;

public class Blog {
	
	private int id;
	private String name;
	private String content;
	private Date createDate;
	private int createUser;
	/** The name of property should be the same as database column*/
	private Date editDate;
	private int editUser;
	private int authorId;
	private String title;
	private String status;
	
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
	
	/**
	 * Gets authorId
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}
	
	/**
	 * Sets authorId the authorId
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	
	/**
	 * Gets title
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title the title
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Gets status
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets status the status
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Blog [id=" + id + ", name=" + name + ", content=" + content + ", createDate=" + createDate
				+ ", createUser=" + createUser + ", editDate=" + editDate + ", editUser=" + editUser + ", authorId="
				+ authorId + ", title=" + title + ", status=" + status + "]";
	}

}
