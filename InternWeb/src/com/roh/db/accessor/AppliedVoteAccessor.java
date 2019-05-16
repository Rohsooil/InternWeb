package com.roh.db.accessor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.roh.model.AppliedVote;

public class AppliedVoteAccessor extends DBAccessor {

	public AppliedVote select(int voteNum) throws ServletException {
		String sql = "Select vote_num, title, startDate, endDate, applyDate from vote where vote_num = ?;";
		AppliedVote appliedVote = null;
		try {
			PreparedStatement pstmt = getPreparedStatement(sql);

			pstmt.setInt(1, voteNum);

			ResultSet resultSet = pstmt.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			appliedVote = new AppliedVote();
			if (resultSet.next()) {
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					appliedVote.setInstance(i, resultSet.getString(i));
				}
			}

			close(pstmt.getConnection(), pstmt, resultSet);
		} catch (SQLException e) {
			throw new ServletException(e);
		}

		return appliedVote;
	}

}
