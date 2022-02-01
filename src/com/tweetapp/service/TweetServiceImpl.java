/**
 * 
 */
package com.tweetapp.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.tweetapp.dao.TweetsDAO;
import com.tweetapp.dao.TweetsDAOImpl;
import com.tweetapp.model.Tweet;

/**
 * @author Nathaniel Roy
 *
 */
public class TweetServiceImpl implements TweetService {

	private static Logger logger = Logger.getLogger(TweetServiceImpl.class);

	Scanner sc = new Scanner(System.in);

	TweetsDAO tweetDao = new TweetsDAOImpl();

	@Override
	public void postTweet(String userEmail) {
		// TODO Auto-generated method stub
		Tweet tweet = new Tweet();
		System.out.println();
		System.out.println("Kindly type your tweet: ");
		tweet.setTweets(sc.nextLine());

		tweetDao.postTweet(userEmail, tweet);
		System.out.println();
		System.out.println();

	}

	@Override
	public void viewTweets() {
		// TODO Auto-generated method stub

		try {
			tweetDao.viewTweets();
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}

	}

	@Override
	public void viewMyTweets(String userEmail) {
		try {
			tweetDao.viewMyTweets(userEmail);
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}

	}

	@Override
	public void viewAllUsers() {
		try {
			tweetDao.viewAllUsers();
			System.out.println();
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}

	}

	@Override
	public void resetPassword(String userEmail, String userPassword, String newpw) {
		try {
			tweetDao.resetPassword(userEmail, userPassword, newpw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e);
		}
	}

	@Override
	public void logout(String userEmail) {
		try {
			tweetDao.logout(userEmail);
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
