/**
 * 
 */
package com.tweetapp.service;

/**
 * @author Nathaniel Roy
 *
 */
public interface LoginUserService {

	public void userLogin(String userEmail, String userPassword);

	public void updatePassword(String userEmail, String userPassword, String newpw);

}
