package com.roh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/rlhvote?serverTimezone=UTC";
	private final String USER = "root";
	private final String PW = "root";

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PW);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return connection;
	}

}
