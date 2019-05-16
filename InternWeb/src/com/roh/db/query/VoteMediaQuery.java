package com.roh.db.query;

public class VoteMediaQuery implements ApplicationQuery {

	public String getInsertQuery(int voteNum) {
		String preparedSql = "INSERT INTO vote_media(vote_num, pc, smartPhone, sms, onSite) " + "values(" + voteNum + " ,?, ?, ?, ?)";

		return preparedSql;
	}

	public String getSelectQuery(int voteNum) {
		String preparedSql = "Select pc, smartPhone, sms, onSite from vote_media where vote_num = ";

		return preparedSql + voteNum + ";";
	}

	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE vote_media set pc=?, smartPhone=?, sms =?, onSite=? where vote_num = " + voteNum + ";";

		return preparedSql;
	}

}
