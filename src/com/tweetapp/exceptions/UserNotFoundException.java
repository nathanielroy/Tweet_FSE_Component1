package com.tweetapp.exceptions;

/**
 * @author Nathaniel Roy
 *
 */
public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 8767904379807231640L;

	public UserNotFoundException(String string) {
		super(string);
	}

}
