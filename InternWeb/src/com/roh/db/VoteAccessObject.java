package com.roh.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.roh.dto.VoteDTO;
import com.roh.model.Vote;

public class VoteAccessObject {
	private final String insertQuery = "INSERT INTO vote(vote_title, vote_type, vote_estimate, vote_startday, vote_endday) values(?, ?, ?, ?, ?); ";
	private final String selectQuery = "Select * from vote where vote_num = ?";
	private final String updateQuery = "UPDATE vote set vote_title=?, vote_type=?, vote_estimate =?, vote_startday=?, vote_endday=? where vote_num = ?;";

	public int insert(DBConnector dbConnector, Vote vote) throws SQLException {
		int vote_num = 0;
		Connection connection = new DBConnector().getConnection();
		PreparedStatement pstmt = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS);
		pstmt.setString(1, vote.getTitle());
		pstmt.setInt(2, vote.getType());
		pstmt.setInt(3, vote.getEstimate());
		pstmt.setString(4, vote.getStartDay().toString());
		pstmt.setString(5, vote.getEndDay().toString());

		pstmt.executeUpdate();

		ResultSet resultSet = pstmt.getGeneratedKeys();
		vote_num = (resultSet.next()) ? resultSet.getInt(1) : 0;

		dbConnector.close(connection, pstmt, resultSet);

		return vote_num;
	}

	public Vote select(DBConnector dbConnector, int voteNum) throws SQLException {
		Vote vote = new Vote();
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(selectQuery);

		pstmt.setInt(1, voteNum);

		ResultSet resultSet = pstmt.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();

		if (resultSet.next()) {
			for (int i = 2; i <= rsmd.getColumnCount(); i++) {
				vote.setInstance(i - 1, resultSet.getString(i));
			}
		}

		dbConnector.close(connection, pstmt, resultSet);

		return vote;
	}

	public int update(DBConnector dbConnector, int vote_num, Vote vote) throws SQLException {

		int result = 0;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(updateQuery);

		pstmt.setString(1, vote.getTitle());
		pstmt.setInt(2, vote.getType());
		pstmt.setInt(3, vote.getEstimate());
		pstmt.setString(4, vote.getStartDay().toString());
		pstmt.setString(5, vote.getEndDay().toString());
		pstmt.setInt(6, vote_num);

		result = pstmt.executeUpdate();

		dbConnector.close(connection, pstmt, null);

		return result;
	}

	public VoteDTO selectAppliedVote(DBConnector dbConnector, int voteNum) throws SQLException {
		String sql = "Select vote_num, vote_title, vote_startday, vote_endday, vote_applyday from vote where vote_num = ?";
		VoteDTO voteD = null;
		Connection connection = dbConnector.getConnection();
		PreparedStatement pstmt = connection.prepareStatement(sql);

		pstmt.setInt(1, voteNum);

		ResultSet resultSet = pstmt.executeQuery();
		ResultSetMetaData rsmd = resultSet.getMetaData();
		voteD = new VoteDTO();
		if (resultSet.next()) {
			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				voteD.setInstance(i, resultSet.getString(i));
			}
		}

		dbConnector.close(connection, pstmt, resultSet);

		return voteD;
	}

}
