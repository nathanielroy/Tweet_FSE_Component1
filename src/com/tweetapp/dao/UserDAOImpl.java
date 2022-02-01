/**
 * 
 */
package com.tweetapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.util.Date;

import org.apache.log4j.Logger;

import com.tweetapp.constants.SqlConstants;
import com.tweetapp.model.User;
import com.tweetapp.utils.DbUtils;

/**
 * @author Nathaniel Roy
 *
 */
public class UserDAOImpl implements UserDAO {

	private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	DbUtils dbConn = new DbUtils();

	@Override
	public void createUser(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		conn = DbUtils.createConnection();
		Date date = new Date();
		Timestamp ts = new Timestamp(date.getTime());
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		String sql = SqlConstants.userInsertQuery;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getUserFullName());
			stmt.setString(2, user.getUserEmail());
			stmt.setString(3, user.getUserPassword());
			stmt.setString(4, formatter.format(ts));
			stmt.executeUpdate();
			logger.info("New User has been created");

		} catch (SQLException e) {

			logger.error("Error generated" + e.getMessage());
		} finally {
			dbConn.closeConnection(conn);
		}

	}

}
