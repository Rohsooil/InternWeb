package com.roh.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.roh.model.DBModel;

public class DBAccessObject {

	public void insert(String sql, DBModel model) throws ServletException {
		try {
			PreparedStatement pstmt = new DBConnector().getPreparedStatement(sql);

			int qmNum = countQuestionMark(sql);
			for (int i = 1; i <= qmNum; i++) {
				pstmt.setString(i, model.getMember(i));
			}

			pstmt.executeUpdate();

			close(pstmt.getConnection(), pstmt, null);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

	public int insert(String sql, DBModel model, int flag) throws ServletException {
		int qmNum = countQuestionMark(sql);
		int result = 0;
		try {
			PreparedStatement pstmt = new DBConnector().getPreparedStatement(sql, flag);

			for (int i = 1; i <= qmNum; i++) {
				pstmt.setString(i, model.getMember(i));
			}

			pstmt.executeUpdate();

			ResultSet resultSet = pstmt.getGeneratedKeys();
			result = (resultSet.next()) ? resultSet.getInt(1) : 0;

			close(pstmt.getConnection(), pstmt, resultSet);
		} catch (SQLException e) {
			throw new ServletException(e);

		}
		return result;
	}

	public DBModel select(String sql, Class<? extends DBModel> cls) throws ServletException {
		DBModel model = null;
		try {
			model = cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		try {
			PreparedStatement pstmt = new DBConnector().getPreparedStatement(sql);

			ResultSet resultSet = pstmt.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();

			if (resultSet.next()) {
				for (int i = 2; i <= rsmd.getColumnCount(); i++) {
					model.setMember(i - 1, resultSet.getString(i));
				}
			}

			close(pstmt.getConnection(), pstmt, resultSet);
		} catch (SQLException e) {
			throw new ServletException(e);

		}
		return model;
	}

	private int countQuestionMark(String sql) {
		char[] charArr = sql.toCharArray();
		int count = 0;
		for (int i = 0; i < charArr.length; i++) {
			if (charArr[i] == '?') {
				count++;
			}
		}

		return count;
	}

	private void close(Connection connection, PreparedStatement pstmt, ResultSet resultSet) throws SQLException {
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
