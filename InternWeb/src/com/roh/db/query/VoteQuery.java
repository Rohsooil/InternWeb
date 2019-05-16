package com.roh.db.query;

public class VoteQuery implements ApplicationQuery {

	public String getInsertQuery() {
		String preparedSql = "INSERT INTO vote(title, type, estimate, startDate, endDate) values(?, ?, ?, ?, ?); ";

		return preparedSql;
	}

	public String getSelectQuery(int voteNum) {
		String preparedSql = "Select title, type, estimate, startDate, endDate from vote where vote_num = ";
		return preparedSql + voteNum + ";";
	}

	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE vote set title=?, type=?, estimate =?, startDate=?, endDate=? where vote_num = ";
		return preparedSql + voteNum + ";";
	}

}
