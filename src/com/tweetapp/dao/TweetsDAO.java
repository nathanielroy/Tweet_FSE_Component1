/**
 * 
 */
package com.tweetapp.dao;

import com.tweetapp.model.Tweet;

/**
 * @author Nathaniel Roy
 *
 */
public interface TweetsDAO {

	public void postTweet(String userEmail, Tweet tweet);

	public void viewMyTweets(String userEmail);

	public void viewTweets();

	public void viewAllUsers();

	public void resetPassword(String userEmail, String userPassword, String newpw);

	public void logout(String userEmail);

}
