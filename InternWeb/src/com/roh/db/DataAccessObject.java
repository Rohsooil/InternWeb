package com.roh.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashSet;

import com.roh.dto.VoteDTO;

public class DataAccessObject {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/rlhvote?serverTimezone=UTC";
	private static final String USER = "roh";
	private static final String PW = "dkdidi12";

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

	public Integer[] findVoteNum(String adminName, String adminPhone) {
		Integer[] result = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT vote_num FROM `admin` WHERE admin_name = ? AND admin_phone = ?";

		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, adminName);
			preparedStatement.setString(2, adminPhone);

			ResultSet rs = preparedStatement.executeQuery();
			HashSet<Integer> hs = new HashSet<>();
			// System.out.println(rs.getArray(1));
			int index = 1;
			while (rs.next()) {
				hs.add(rs.getInt(index));
			}
			rs.close();
			result = hs.toArray(new Integer[hs.size()]);
			// result = hs.toArray(result);
//			result = (rs.next()) ? rs.getInt(1) : 0;
//			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, null);
		}
		return result;
	}

	public VoteDTO findAppliedVote(int voteNum) {
		VoteDTO voteD = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "Select vote_num, vote_title, vote_startday, vote_endday, vote_applyday from vote where vote_num = ?";

		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setInt(1, voteNum);

			ResultSet rs = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			voteD = new VoteDTO();
			if (rs.next()) {
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					voteD.setInstance(i, rs.getString(i));
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, null);
		}
		return voteD;
	}

	private void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
