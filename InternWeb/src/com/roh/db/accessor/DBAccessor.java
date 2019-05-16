package com.roh.db.accessor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.roh.db.connector.DBConnector;

public class DBAccessor {

	PreparedStatement getPreparedStatement(String sql, int flag) throws SQLException {
		PreparedStatement pstmt = new DBConnector().getConnection().prepareStatement(sql, flag);

		return pstmt;
	}

	PreparedStatement getPreparedStatement(String sql) throws SQLException {
		PreparedStatement pstmt = new DBConnector().getConnection().prepareStatement(sql);

		return pstmt;
	}

	void close(Connection connection, PreparedStatement pstmt, ResultSet resultSet) throws SQLException {
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
