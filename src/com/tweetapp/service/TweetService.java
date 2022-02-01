/**
 * 
 */
package com.tweetapp.service;

/**
 * @author Nathaniel Roy
 *
 */
public interface TweetService {

	public void postTweet(String userEmail);

	public void viewMyTweets(String userEmail);

	public void viewTweets();

	public void viewAllUsers();

	public void resetPassword(String userEmail, String userPassword, String newpw);

	public void logout(String userEmail);

}
