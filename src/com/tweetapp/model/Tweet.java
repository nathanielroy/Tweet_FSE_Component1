/**
//Tweet Model
 * 
 */
package com.tweetapp.model;

/**
 * @author Nathaniel Roy
 *
 */
public class Tweet {

	private int tweetId;
	private String tweets;
	private User userId;
	private User userEmail;
	private String createdAt;

	public int getTweetId() {
		return tweetId;
	}

	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweets() {
		return tweets;
	}

	public void setTweets(String tweets) {
		this.tweets = tweets;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public User getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(User userEmail) {
		this.userEmail = userEmail;
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

}
