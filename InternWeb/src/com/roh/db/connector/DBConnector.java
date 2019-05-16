package com.roh.db.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBConnector {
	// private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/rlhvote";
	private final String USER = "root";
	private final String PW = "root";

	public Connection getConnection() throws SQLException {
		new Driver();

		return DriverManager.getConnection(URL, USER, PW);
	}

}
