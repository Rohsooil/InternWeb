package com.roh.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import com.roh.db.DBConnector;

public class AdminQueryMaker implements QueryMaker {

	@Override
	public String getInsertQuery(int voteNum) {
		String preparedSql = "INSERT INTO `admin`(vote_num, admin_type, admin_name, admin_rank, admin_tel, admin_phone, admin_email)" + "values("
				+ voteNum + " ,?, ?, ?, ?, ?, ?)";

		return preparedSql;
	}

	@Override
	public String getSelectQuery(int voteNum) {
		String preparedSql = "Select * from `admin` where vote_num = ";
		return preparedSql + voteNum;
	}

	@Override
	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE `admin` set admin_type=?, admin_name=?, admin_rank=?, admin_tel=?, admin_phone=?, admin_email=? where vote_num = "
				+ voteNum + ";";
		return preparedSql;
	}

	public Integer[] selectVoteNum(DBConnector dbConnector, String adminName, String adminPhone) throws SQLException {
		String sql = "SELECT vote_num FROM `admin` WHERE admin_name = ? AND admin_phone = ?";
		Integer[] result = null;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);
		pstmt.setString(1, adminName);
		pstmt.setString(2, adminPhone);

		ResultSet resultSet = pstmt.executeQuery();
		HashSet<Integer> hs = new HashSet<>();
		// System.out.println(rs.getArray(1));
		int index = 1;
		while (resultSet.next()) {
			hs.add(resultSet.getInt(index));
		}
		resultSet.close();
		result = hs.toArray(new Integer[hs.size()]);

		//dbConnector.close(connection, pstmt, resultSet);
		return result;
	}

}
