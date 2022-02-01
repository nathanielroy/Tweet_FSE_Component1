/**
 * 
 */
package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.tweetapp.constants.SqlConstants;
import com.tweetapp.exceptions.NoDataFoundException;
import com.tweetapp.exceptions.UserNotFoundException;
import com.tweetapp.model.Tweet;
import com.tweetapp.utils.DbUtils;

/**
 * @author Nathaniel Roy
 *
 */
public class TweetsDAOImpl implements TweetsDAO {

	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	DbUtils dbConn = new DbUtils();

	@Override
	public void postTweet(String userEmail, Tweet tweet) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DbUtils.createConnection();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		String sql = SqlConstants.tweetInsertQuery;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, tweet.getTweets());
			stmt.setString(2, userEmail);
			stmt.setString(3, formatter.format(ts));
			stmt.executeUpdate();
			logger.info("New Tweet is been posted");

		} catch (SQLException e) {

			logger.error("Error generated" + e.getMessage());
		} finally {
			dbConn.closeConnection(conn);

		}
	}

	@Override
	public void viewTweets() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DbUtils.createConnection();
		String sql = SqlConstants.view_tweets_Query;
		int count = 1;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next() == false) {
				logger.info("ResultSet in empty in Java");
				throw new NoDataFoundException("No data");
			} else {
				do {
					System.out.print(count + ": ");
					System.out.print(rs.getString("tweets"));
					System.out.println();
					count++;
				} while (rs.next());
			}
			logger.info("The User has requested to view all Tweets.");
		} catch (SQLException | NoDataFoundException e) {

			logger.error("Error generated: " + e.getMessage());
		} finally {
			dbConn.closeConnection(conn);

		}
	}

	@Override
	public void viewMyTweets(String userEmail) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DbUtils.createConnection();

		String sql = SqlConstants.view_my_tweets_Query;
		int count = 1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userEmail);
			rs = ps.executeQuery();
			if (rs.next() == false) {
				logger.info("ResultSet in empty in Java");
				throw new NoDataFoundException("No data");
			} else {
				do {
					System.out.print(count + ": ");
					System.out.print(rs.getString("tweets"));
					System.out.println();
					count++;
				} while (rs.next());
			}
			logger.info("The User has requested to view his/her Tweets.");
		} catch (SQLException | NoDataFoundException e) {

			logger.error("Error generated: " + e.getMessage());
		} finally {
			dbConn.closeConnection(conn);

		}

	}

	@Override
	public void viewAllUsers() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = DbUtils.createConnection();
		String sql = SqlConstants.view_users_Query;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next() == false) {
				logger.info("ResultSet in empty in Java");
				throw new UserNotFoundException("No Users in the system.");
			} else {
				do {
					System.out.print("User ID is: " + rs.getInt("userId") + ", ");
					System.out.print("User Full Name is: " + rs.getString("userFullName") + ", ");
					System.out.print("User Email is: " + rs.getString("userEmail"));
					System.out.println();
				} while (rs.next());
			}
			logger.info("The User has requested to view all the Users.");

		} catch (SQLException | UserNotFoundException e) {

			logger.error("Error generated: " + e.getMessage());
		} finally {
			dbConn.closeConnection(conn);

		}

	}

	@Override
	public void resetPassword(String userEmail, String userPassword, String newpw) {
		Connection conn = null;
		conn = DbUtils.createConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		try {
			ps1 = conn.prepareStatement(SqlConstants.user_login_Query);
			ps1.setString(1, userEmail);
			ps1.setString(2, userPassword);
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()) {
				int userId = rs1.getInt(1);
				ps2 = conn.prepareStatement(SqlConstants.user_password_update);
				ps2.setString(1, newpw);
				ps2.setInt(2, userId);
				ps2.executeUpdate();
				logger.info("Updated Password Successfully in user table");

			} else {
				throw new UserNotFoundException("Please enter correct password for Email: " + userEmail);
			}
		} catch (SQLException | UserNotFoundException e) {
			logger.error("Error generated: " + e.getMessage());
		} finally {
			dbConn.closeConnection(conn);
		}

	}

	@Override
	public void logout(String userEmail) {
		Connection conn = null;
		conn = DbUtils.createConnection();
		PreparedStatement ps1 = null;
		try {
			ps1 = conn.prepareStatement(SqlConstants.user_inactive_status_update);
			ps1.setString(1, userEmail);
			ps1.executeUpdate();
		} catch (SQLException e) {
			logger.error("Error generated: " + e.getMessage());
		} finally {
			dbConn.closeConnection(conn);
		}
	}

}
