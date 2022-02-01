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
import com.tweetapp.exceptions.UserNotFoundException;
import com.tweetapp.utils.DbUtils;

/**
 * @author Nathaniel Roy
 *
 */
public class LoginUserDAOImpl implements LoginUserDAO {

	private static Logger logger = Logger.getLogger(LoginUserDAOImpl.class);

	DbUtils dbConn = new DbUtils();

	@Override
	public void userLogin(String userEmail, String userPassword) throws Exception {
		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		conn = DbUtils.createConnection();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		String sql1 = SqlConstants.user_email_check_Query;
		String sql2 = SqlConstants.user_login_Query;

		try {
			ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, userEmail);
			rs1 = ps1.executeQuery();
			if (rs1.next()) {
				ps2 = conn.prepareStatement(sql2);
				ps2.setString(1, userEmail);
				ps2.setString(2, userPassword);
				rs2 = ps2.executeQuery();
				if (rs2.next()) {
					System.out.println("WELCOME User : " + rs2.getString(3) + "  Login Time :  "
							+ java.time.format.DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")
									.format(java.time.LocalDateTime.now()));
					ps3 = conn.prepareStatement(SqlConstants.user_active_status_update);
					ps3.setString(1, formatter.format(ts));
					ps3.setString(2, userEmail);
					ps3.executeUpdate();
					logger.info("The User with the Email: " + userEmail + " has logged in.");

				} else {
					throw new UserNotFoundException("Please enter correct password for " + userEmail);
				}
			} else {
				throw new UserNotFoundException("User is not available for the Email: " + userEmail);
			}

		} catch (SQLException e) {
			logger.error("Error generated" + e.getMessage());
		} finally {
			dbConn.closeConnection(conn);
		}

	}

	@Override
	public void updatePassword(String userEmail, String userPassword, String newpw) {
		Connection conn = null;
		conn = DbUtils.createConnection();
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		try {
			ps1 = conn.prepareStatement(SqlConstants.user_email_check_Query);
			ps1.setString(1, userEmail);
			ResultSet rs1 = ps1.executeQuery();
			if (rs1.next()) {
				ps2 = conn.prepareStatement(SqlConstants.user_login_Query);
				ps2.setString(1, userEmail);
				ps2.setString(2, userPassword);
				ResultSet rs2 = ps2.executeQuery();
				if (rs2.next()) {
					int userId = rs2.getInt(1);
					ps3 = conn.prepareStatement(SqlConstants.user_password_update);
					ps3.setString(1, newpw);
					ps3.setInt(2, userId);
					ps3.executeUpdate();
					logger.info("Updated Password Successfully in user table");

				} else {
					throw new UserNotFoundException("Please enter correct password for Email: " + userEmail);
				}
			} else {
				throw new UserNotFoundException("User is not available for the Email: " + userEmail);
			}

		}

		catch (SQLException | UserNotFoundException e) {
			logger.error("Error generated" + e.getMessage());
		} finally {
			dbConn.closeConnection(conn);
		}

	}

}
