package com.roh.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.roh.db.accessor.DBAccessor;
import com.roh.model.AppliedVote;

public class AppliedVoteAccessor implements DBAccessor {

	public AppliedVote select(int voteNum) throws ServletException {
		String sql = "Select vote_num, vote_title, vote_startday, vote_endday, vote_applyday from vote where vote_num = ?;";
		AppliedVote appliedVote = null;
		try {
			PreparedStatement pstmt = new DBConnector().getPreparedStatement(sql);

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
