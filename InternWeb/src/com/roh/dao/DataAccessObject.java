package com.roh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.roh.model.Admin;
import com.roh.model.Apartment;
import com.roh.model.FilePath;
import com.roh.model.Vote;

public class DataAccessObject {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/rlhvote?serverTimezone=UTC";
	private static final String USER = "root";
	private static final String PW = "root";

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

	public int insertVote(Vote vote) {
		int vote_num = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO vote(vote_title, vote_type, vote_estimate, vote_startday, vote_endday) values(?, ?, ?, ?, ?); ";

		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, vote.getTitle());
			preparedStatement.setInt(2, vote.getType());
			preparedStatement.setInt(3, vote.getEstimate());
			preparedStatement.setString(4, vote.getStartDay());
			preparedStatement.setString(5, vote.getEndDay());

			preparedStatement.executeUpdate();
			ResultSet rs = preparedStatement.getGeneratedKeys();
			vote_num = (rs.next()) ? rs.getInt(1) : 0;
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, null);
		}
		return vote_num;
	}

	public int insertVoteMedia(int vote_num, String[] media) {
		int rowCount = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// String getMaxSql = "(SELECT LAST_INSERT_ID())";
		// String getMaxSql = "(SELECT MAX(vote_num) FROM vote)";
		String sql = "INSERT INTO vote_media(vote_num, type1, type2, type3, type4) " + "values(" + vote_num
				+ " ,?, ?, ?, ?)";
		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			for (int i = 1; i < media.length + 1; i++) {
				preparedStatement.setInt(i, Integer.parseInt(media[i - 1]));
			}

			for (int i = media.length; i < 4; i++) {
				preparedStatement.setInt(i + 1, 0);
			}

			rowCount = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, null);
		}
		return rowCount;
	}

	public int insertVoteAdmin(int vote_num, Admin admin) {
		int rowCount = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		// String getMaxSql = "(SELECT LAST_INSERT_ID())";
		// String getMaxSql = "(SELECT MAX(vote_num) FROM vote)";
		String sql = "INSERT INTO admin(vote_num, admin_type, admin_name, admin_rank, admin_tel, admin_phone, admin_email)"
				+ "values(" + vote_num + " ,?, ?, ?, ?, ?, ?)";
		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, admin.getType());
			preparedStatement.setString(2, admin.getName());
			preparedStatement.setString(3, admin.getRank());
			preparedStatement.setString(4, admin.getTel());
			preparedStatement.setString(5, admin.getPhone());
			preparedStatement.setString(6, admin.getEmail());

			rowCount = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, null);
		}
		return rowCount;
	}

	public int insertVoteApart(int vote_num, Apartment apart) {
		int rowCount = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO apart(vote_num, apart_name, apart_type, register_num, rep_type, rep_name, apart_tel, apart_fax, apart_address)"
				+ "values(" + vote_num + " ,?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, apart.getApartName());
			preparedStatement.setInt(2, apart.getApartType());
			preparedStatement.setString(3, apart.getRegisterNum());
			preparedStatement.setInt(4, apart.getRepType());
			preparedStatement.setString(5, apart.getRepName());
			preparedStatement.setString(6, apart.getTel());
			preparedStatement.setString(7, apart.getFax());
			preparedStatement.setString(8, apart.getAddress());

			rowCount = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, null);
		}
		return rowCount;
	}

	public int insertVoteFilePath(int vote_num, FilePath filePath) {
		int rowCount = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "INSERT INTO file_path(vote_num, regis_num_card, base_doc, manager_certify, pers_agreement, usage_agreement)"
				+ "values(" + vote_num + " , ?, ?, ?, ?, ?)";
		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, filePath.getRegisNumCardPath());
			preparedStatement.setString(2, filePath.getBaseDocPath());
			preparedStatement.setString(3, filePath.getManagerCertifyPath());
			preparedStatement.setString(4, filePath.getPersAgreementPath());
			preparedStatement.setString(5, filePath.getUsageAgreementPath());

			rowCount = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, null);
		}
		return rowCount;
	}

	public int isVoteAdmin(String adminName, String adminPhone) {
		int result = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = "SELECT EXISTS (SELECT * FROM admin WHERE admin_name = ? AND admin_phone = ? ) AS isAdmin";

		try {
			connection = this.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, adminName);
			preparedStatement.setString(2, adminPhone);

			ResultSet rs = preparedStatement.executeQuery();
			result = (rs.next()) ? rs.getInt(1) : 0;
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(connection, preparedStatement, null);
		}
		return result;
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
