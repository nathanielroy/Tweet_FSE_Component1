package com.tweetapp.app;

import org.apache.log4j.Logger;

public class TweetApplication {
	
	private static Logger logger = Logger.getLogger(TweetApplication.class);
	
	public static void main(String[] args) {
		
		logger.info("The application has started");
		
		MainTweetMenu mainMenu = new MainTweetMenu();
		mainMenu.mainMenu();
		
	}	
}