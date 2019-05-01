package com.roh.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.roh.model.Apartment;

public class ApartAccessObject {

	public int insert(DBConnector dbConnector, int vote_num, Apartment apart) throws SQLException {
		String sql = "INSERT INTO apart(vote_num, apart_name, apart_type, register_num, rep_type, rep_name, apart_tel, apart_fax, apart_address)"
				+ "values(" + vote_num + " ,?, ?, ?, ?, ?, ?, ?, ?)";
		int rowCount = 0;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setString(1, apart.getApartName());
		pstmt.setInt(2, apart.getApartType());
		pstmt.setString(3, apart.getRegisterNum());
		pstmt.setInt(4, apart.getRepType());
		pstmt.setString(5, apart.getRepName());
		pstmt.setString(6, apart.getTel());
		pstmt.setString(7, apart.getFax());
		pstmt.setString(8, apart.getAddress());

		rowCount = pstmt.executeUpdate();

		dbConnector.close(connection, pstmt, null);
		return rowCount;
	}

	public Apartment select(DBConnector dbConnector, int voteNum) throws SQLException {
		String sql = "Select * from apart where vote_num = ?";
		Apartment apartment = null;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setInt(1, voteNum);

		ResultSet resultSet = pstmt.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();

		apartment = new Apartment();
		if (resultSet.next()) {
			for (int i = 2; i <= rsmd.getColumnCount(); i++) {
				apartment.setInstance(i - 1, resultSet.getString(i));
			}
		}
		dbConnector.close(connection, pstmt, resultSet);
		return apartment;
	}

	public int update(DBConnector dbConnector, int vote_num, Apartment apart) throws SQLException {
		String sql = "UPDATE apart set apart_name=?, apart_type=?, register_num =?, rep_type=?, rep_name=?, apart_tel=?, apart_fax=?, apart_address=? where vote_num = "
				+ vote_num + ";";
		int result = 0;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, apart.getApartName());
		pstmt.setInt(2, apart.getApartType());
		pstmt.setString(3, apart.getRegisterNum());
		pstmt.setInt(4, apart.getRepType());
		pstmt.setString(5, apart.getRepName());
		pstmt.setString(6, apart.getTel());
		pstmt.setString(7, apart.getFax());
		pstmt.setString(8, apart.getAddress());

		result = pstmt.executeUpdate();

		dbConnector.close(connection, pstmt, null);

		return result;
	}

}
