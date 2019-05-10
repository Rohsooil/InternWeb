package com.roh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

	public PreparedStatement getPreparedStatement(String sql, int flag) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql, flag);

		return pstmt;
	}

	public PreparedStatement getPreparedStatement(String sql) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		return pstmt;
	}
}
