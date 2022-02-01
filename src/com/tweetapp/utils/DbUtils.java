package com.tweetapp.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import com.lt.crs.validation.LoginValidation;

public class DbUtils {

	/**
	 * this method is to read the configuration file
	 *
	 */
	public static Properties loadPropertiesFile() throws Exception {

		Properties prop = new Properties();
		InputStream in = new FileInputStream("db.properties");
		prop.load(in);
		in.close();
		return prop;
	}

	/**
	 * this method is to made connection with database abd return database
	 * connection
	 * 
	 * @return Connection
	 */
	public static Connection createConnection() {

		Connection con = null;

		try {

			Properties prop = loadPropertiesFile();

			String driverClass = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String username = prop.getProperty("username");
			String password = prop.getProperty("password");

			Class.forName(driverClass);

			con = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeConnection(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}