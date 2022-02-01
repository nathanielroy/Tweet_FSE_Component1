/**
 * 
 */
package com.tweetapp.service;

import org.apache.log4j.Logger;

import com.tweetapp.app.MainTweetMenu;
import com.tweetapp.app.TweetsMenu;
import com.tweetapp.dao.LoginUserDAO;
import com.tweetapp.dao.LoginUserDAOImpl;

/**
 * @author Nathaniel Roy
 *
 */
public class LoginUserServiceImpl implements LoginUserService {

	private static Logger logger = Logger.getLogger(LoginUserServiceImpl.class);

	@Override
	public void userLogin(String userEmail, String userPassword) {
		LoginUserDAO loginUserDao = new LoginUserDAOImpl();
		try {
			loginUserDao.userLogin(userEmail, userPassword);
			TweetsMenu tweetMenu = new TweetsMenu();
			tweetMenu.tweetMenu(userEmail);
		} catch (Exception e) {
			logger.error(e);
			MainTweetMenu mainMenu = new MainTweetMenu();
			mainMenu.mainMenu();
		}

	}

	@Override
	public void updatePassword(String userEmail, String userPassword, String newpw) {
		LoginUserDAO loginUserDao = new LoginUserDAOImpl();
		loginUserDao = new LoginUserDAOImpl();
		try {
			loginUserDao.updatePassword(userEmail, userPassword, newpw);
		} catch (Exception e) {
			logger.error(e);
		}
	}

}
