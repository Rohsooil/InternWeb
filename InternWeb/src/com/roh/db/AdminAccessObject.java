package com.roh.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.roh.model.Admin;

public class AdminAccessObject {

	public int insert(DBConnector dbConnector, int vote_num, Admin admin) throws SQLException {
		String sql = "INSERT INTO `admin`(vote_num, admin_type, admin_name, admin_rank, admin_tel, admin_phone, admin_email)"
				+ "values(" + vote_num + " ,?, ?, ?, ?, ?, ?)";
		int rowCount = 0;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, admin.getType());
		pstmt.setString(2, admin.getName());
		pstmt.setString(3, admin.getRank());
		pstmt.setString(4, admin.getTel());
		pstmt.setString(5, admin.getPhone());
		pstmt.setString(6, admin.getEmail());

		rowCount = pstmt.executeUpdate();

		dbConnector.close(connection, pstmt, null);
		return rowCount;
	}

	public Admin select(DBConnector dbConnector, int voteNum) throws SQLException {
		String sql = "Select * from `admin` where vote_num = ?";
		Admin admin = null;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setInt(1, voteNum);

		ResultSet resultSet = pstmt.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();
		admin = new Admin();

		if (resultSet.next()) {
			for (int i = 2; i <= rsmd.getColumnCount(); i++) {
				admin.setInstance(i - 1, resultSet.getString(i));
			}
		}
		dbConnector.close(connection, pstmt, resultSet);
		return admin;
	}

	public int update(DBConnector dbConnector, int vote_num, Admin admin) throws SQLException {
		String sql = "UPDATE `admin` set admin_type=?, admin_name=?, admin_rank=?, admin_tel=?, admin_phone=?, admin_email=? where vote_num = "
				+ vote_num + ";";
		int result = 0;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setInt(1, admin.getType());
		pstmt.setString(2, admin.getName());
		pstmt.setString(3, admin.getRank());
		pstmt.setString(4, admin.getTel());
		pstmt.setString(5, admin.getPhone());
		pstmt.setString(6, admin.getEmail());

		result = pstmt.executeUpdate();

		dbConnector.close(connection, pstmt, null);
		return result;
	}

}
