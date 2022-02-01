/**
 * 
 */
package com.tweetapp.exceptions;

/**
 * @author Nathaniel Roy
 *
 */
public class NoDataFoundException extends Exception {

	private static final long serialVersionUID = 5566734545801420859L;

	/**
	 * @param string
	 */
	public NoDataFoundException(String string) {
		super(string);
	}

}
