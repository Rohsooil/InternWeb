package com.roh.db.query.application;

import com.roh.db.query.ApplicationQuery;

public class VoteQuery implements ApplicationQuery {

	@Override
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

}
