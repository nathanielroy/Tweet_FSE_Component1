/**
 * 
 */
package com.tweetapp.app;

import java.util.Scanner;

import com.tweetapp.service.TweetService;
import com.tweetapp.service.TweetServiceImpl;

/**
 * @author Nathaniel Roy
 *
 */
public class TweetsMenu {

	Scanner sc = new Scanner(System.in);

	public void tweetMenu(String userEmail) {
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t-----WELCOME TO TWEET MENU-----");
		System.out.println();
		System.out.println("Main Menu");
		System.out.println("-----------------------------");
		System.out.println("1. Post a tweet");
		System.out.println("2. View my tweets");
		System.out.println("3. View all tweets");
		System.out.println("4. View all Users");
		System.out.println("5. Reset Password");
		System.out.println("6. Logout");
		System.out.println();
		System.out.println("Enter required option : ");
		int mainOption = sc.nextInt();
		sc.nextLine();
		TweetService tweets = new TweetServiceImpl();
		switch (mainOption) {
		case 1:
			tweets.postTweet(userEmail);
			tweetMenu(userEmail);
			break;
		case 2:
			tweets.viewMyTweets(userEmail);
			tweetMenu(userEmail);
			break;
		case 3:
			tweets.viewTweets();
			tweetMenu(userEmail);
			break;
		case 4:
			tweets.viewAllUsers();
			tweetMenu(userEmail);
			break;
		case 5:
			System.out.println();
			System.out.println("Enter Your Old password : ");
			String userPassword = sc.next();
			System.out.println("Enter Your NEW password : ");
			String newpw = sc.next();
			tweets.resetPassword(userEmail, userPassword, newpw);
			tweetMenu(userEmail);
			break;
		case 6:
			tweets.logout(userEmail);
			System.out.println(" The User " + userEmail + " has been logged out");
			MainTweetMenu mainMenu = new MainTweetMenu();
			mainMenu.mainMenu();
		}
	}

}
