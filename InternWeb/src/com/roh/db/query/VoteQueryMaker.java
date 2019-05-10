package com.roh.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.roh.db.DBConnector;
import com.roh.dto.VoteDTO;

public class VoteQueryMaker implements QueryMaker {

	public String getInsertQuery() {
		String preparedSql = "INSERT INTO vote(vote_title, vote_type, vote_estimate, vote_startday, vote_endday) values(?, ?, ?, ?, ?); ";

		return preparedSql;
	}

	@Override
	public String getSelectQuery(int voteNum) {
		String preparedSql = "Select * from vote where vote_num = ";
		return preparedSql + voteNum + ";";
	}

	@Override
	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE vote set vote_title=?, vote_type=?, vote_estimate =?, vote_startday=?, vote_endday=? where vote_num = " + voteNum
				+ ";";
		return preparedSql;
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

		// dbConnector.close(connection, pstmt, resultSet);

		return voteD;
	}

}
