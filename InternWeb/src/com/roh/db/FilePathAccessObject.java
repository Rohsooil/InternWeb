package com.roh.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.roh.model.FilePath;

public class FilePathAccessObject {

	public int insert(DBConnector dbConnector, int vote_num, FilePath filePath) throws SQLException {
		String sql = "INSERT INTO file_path(vote_num, regis_num_card, base_doc, manager_certify, pers_agreement, usage_agreement)"
				+ "values(" + vote_num + " , ?, ?, ?, ?, ?)";
		int rowCount = 0;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, filePath.getRegisNumCardPath());
		pstmt.setString(2, filePath.getBaseDocPath());
		pstmt.setString(3, filePath.getManagerCertifyPath());
		pstmt.setString(4, filePath.getPersAgreementPath());
		pstmt.setString(5, filePath.getUsageAgreementPath());

		rowCount = pstmt.executeUpdate();

		dbConnector.close(connection, pstmt, null);
		return rowCount;
	}

	public FilePath select(DBConnector dbConnector, int voteNum) throws SQLException {
		String sql = "Select * from file_path where vote_num = ?";
		FilePath filePath = null;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setInt(1, voteNum);

		ResultSet resultSet = pstmt.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();
		filePath = new FilePath();
		if (resultSet.next()) {
			for (int i = 2; i <= rsmd.getColumnCount(); i++) {
				filePath.setInstance(i - 1, resultSet.getString(i));
			}
		}

		dbConnector.close(connection, pstmt, resultSet);
		return filePath;
	}

	public int update(DBConnector dbConnector, int vote_num, FilePath filePath) throws SQLException {
		String sql = "UPDATE file_path set regis_num_card=?, base_doc=?, manager_certify =?, pers_agreement=?, usage_agreement=? where vote_num = "
				+ vote_num + ";";
		int result = 0;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setString(1, filePath.getRegisNumCardPath());
		pstmt.setString(2, filePath.getBaseDocPath());
		pstmt.setString(3, filePath.getManagerCertifyPath());
		pstmt.setString(4, filePath.getPersAgreementPath());
		pstmt.setString(5, filePath.getUsageAgreementPath());

		result = pstmt.executeUpdate();

		dbConnector.close(connection, pstmt, null);

		return result;
	}

}
