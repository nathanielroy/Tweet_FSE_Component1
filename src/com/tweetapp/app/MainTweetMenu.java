package com.tweetapp.app;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.tweetapp.service.LoginUserService;
import com.tweetapp.service.LoginUserServiceImpl;
import com.tweetapp.service.UserService;
import com.tweetapp.service.UserServiceImpl;

public class MainTweetMenu {

	private static Logger logger = Logger.getLogger(MainTweetMenu.class);

	Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		logger.info("The application is in Main Menu");
		System.out.println();
		System.out.println("\t\t\t\t\t\t\t-----WELCOME TO TWEET APPLICATION-----");
		System.out.println();
		System.out.println("Main Menu");
		System.out.println("-----------------------------");
		System.out.println("1. Login");
		System.out.println("2. New User");
		System.out.println("3. Forgot Password");
		System.out.println("4. Exit");
		System.out.println();
		System.out.println("Enter required option : ");
		int mainOption = sc.nextInt();
		sc.nextLine();

		switch (mainOption) {
		case 1:
			checkLogin();
			break;
		case 2:
			newUserCreation();
			break;
		case 3:
			updatePassword();
			break;
		case 4:
			System.out.println();
			System.out.println("Exiting Application");
			System.exit(0);
		default:
			System.out.println("User Entered Wrong Choice !!! \n \t Plese use Right Choice. ");
			mainMenu();
		}

	}

	/**
	 * 
	 */
	private void newUserCreation() {
		// TODO Auto-generated method stub
		System.out.println();
		UserService us = new UserServiceImpl();
		us.createUser();
		mainMenu();

	}

	private void checkLogin() {
		LoginUserService user = new LoginUserServiceImpl();
		System.out.println();
		System.out.println("Enter credentials");
		System.out.println("----------------------");
		System.out.println("User Email");
		String userEmail = sc.nextLine();
		System.out.println("Password");
		String userPassword = sc.nextLine();
		user.userLogin(userEmail, userPassword);
	}

	/**
	 * 
	 */
	private void updatePassword() {
		// TODO Auto-generated method stub
		LoginUserService user = new LoginUserServiceImpl();
		System.out.println();
		System.out.println("Enter User Email : ");
		String userEmail = sc.next();
		System.out.println("Enter Your Old password : ");
		String userPassword = sc.next();
		System.out.println("Enter Your NEW password : ");
		String newpw = sc.next();
		user.updatePassword(userEmail, userPassword, newpw);
		mainMenu();

	}

}
