/**
 * 
 */
package com.tweetapp.dao;

/**
 * @author Nathaniel Roy
 *
 */
public interface LoginUserDAO {
	public void userLogin(String userEmail, String userPassword) throws Exception;

	public void updatePassword(String userEmail, String userPassword, String newpw);
}
