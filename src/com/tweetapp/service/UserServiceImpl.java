/**
 * 
 */
package com.tweetapp.service;

import java.util.Scanner;

import com.tweetapp.app.MainTweetMenu;
import com.tweetapp.dao.UserDAO;
import com.tweetapp.dao.UserDAOImpl;
import com.tweetapp.model.User;

/**
 * @author Nathaniel Roy
 *
 */
public class UserServiceImpl implements UserService {

	Scanner sc = new Scanner(System.in);

	UserDAO userDao = new UserDAOImpl();

	@Override
	public void createUser() {
		User user = new User();
		System.out.println();
		System.out.println("Enter User Name: ");
		user.setUserFullName(sc.nextLine());
		System.out.println("Enter User Email: ");
		user.setUserEmail(sc.nextLine());
		System.out.println("Enter User Password: ");
		user.setUserPassword(sc.nextLine());

		userDao.createUser(user);
		System.out.println();
		System.out.println();

		MainTweetMenu mainMenu = new MainTweetMenu();
		mainMenu.mainMenu();
	}

}
