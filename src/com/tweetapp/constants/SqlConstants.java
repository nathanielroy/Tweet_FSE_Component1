/**
 * 
 */
package com.tweetapp.constants;

/**
 * @author Nathaniel Roy
 *
 */
public class SqlConstants {

	public static final String userInsertQuery = "insert into user (userFullName,userEmail,userPassword, createdAt) values(?,?,?,?)";
	public static final String tweetInsertQuery = "insert into tweet (tweets,userEmail, createdAt) values(?,?,?)";

	public static final String user_email_check_Query = "select * from user where userEmail=?";
	public static final String user_login_Query = "select * from user where userEmail=? and userPassword=?";
	public static final String user_password_update = "update user set userPassword=? where userId=?";

	public static final String user_active_status_update = "update user set status='ACTIVE', lastLoggedAt=? where userEmail=?";
	public static final String user_inactive_status_update = "update user set status='INACTIVE' where userEmail=?";

	public static final String view_tweets_Query = "select * from tweet";
	public static final String view_my_tweets_Query = "select * from tweet where userEmail=?";
	public static final String view_users_Query = "select * from user";

	public static final String ACTIVE = "ACTIVE";
	public static final String INACTIVE = "INACTIVE";

}
