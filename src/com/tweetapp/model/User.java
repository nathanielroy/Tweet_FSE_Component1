package com.tweetapp.model;

public class User {

	private int userId;
	private String userFullName;
	private String userEmail;
	private String userPassword;
	private String createdAt;
	private String lastLoggedAt;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFullName() {
		return userFullName;
	}

	public void setUserFullName(String userFullName) {
		this.userFullName = userFullName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the createdAt
	 */
	public String getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the lastLoggedAt
	 */
	public String getLastLoggedAt() {
		return lastLoggedAt;
	}

	/**
	 * @param lastLoggedAt the lastLoggedAt to set
	 */
	public void setLastLoggedAt(String lastLoggedAt) {
		this.lastLoggedAt = lastLoggedAt;
	}

}
