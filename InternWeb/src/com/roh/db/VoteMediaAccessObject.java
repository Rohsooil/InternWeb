package com.roh.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class VoteMediaAccessObject {

	public int insert(DBConnector dbConnector, int vote_num, String[] media) throws SQLException {
		String sql = "INSERT INTO vote_media(vote_num, type1, type2, type3, type4) " + "values(" + vote_num
				+ " ,?, ?, ?, ?)";
		int rowCount = 0;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		for (int i = 1; i < media.length + 1; i++) {
			pstmt.setInt(i, Integer.parseInt(media[i - 1]));
		}

		for (int i = media.length; i < 4; i++) {
			pstmt.setInt(i + 1, 0);
		}

		rowCount = pstmt.executeUpdate();

		dbConnector.close(connection, pstmt, null);
		return rowCount;
	}

	public String[] select(DBConnector dbConnector, int voteNum) throws SQLException {
		String sql = "Select * from vote_media where vote_num = ?";
		String[] vote_media = null;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setInt(1, voteNum);

		ResultSet resultSet = pstmt.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();
		vote_media = new String[rsmd.getColumnCount() - 1];
		if (resultSet.next()) {
			for (int i = 2; i <= rsmd.getColumnCount(); i++) {
				if (resultSet.getInt(i) == 0) {
					break;
				}
				vote_media[i - 2] = resultSet.getInt(i) + "";
			}
		}
		dbConnector.close(connection, pstmt, resultSet);

		return vote_media;
	}

	public int update(DBConnector dbConnector, int vote_num, String[] media) throws SQLException {
		String sql = "UPDATE vote_media set TYPE1=?, TYPE2=?, TYPE3 =?, TYPE4=? where vote_num = " + vote_num + ";";
		int result = 0;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		for (int i = 1; i < media.length + 1; i++) {
			pstmt.setInt(i, Integer.parseInt(media[i - 1]));
		}

		for (int i = media.length; i < 4; i++) {
			pstmt.setInt(i + 1, 0);
		}

		result = pstmt.executeUpdate();

		dbConnector.close(connection, pstmt, null);
		return result;
	}

}
