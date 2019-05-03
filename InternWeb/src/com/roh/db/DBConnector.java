package com.roh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Driver;

public class DBConnector {
	// private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/rlhvote?serverTimezone=UTC";
	private final String USER = "root";
	private final String PW = "root";

	public Connection getConnection() throws SQLException {
		new Driver();

		Connection connection = DriverManager.getConnection(URL, USER, PW);

		return connection;
	}

	public void close(Connection connection, PreparedStatement pstmt, ResultSet resultSet) throws SQLException {
		if (resultSet != null) {
			resultSet.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
