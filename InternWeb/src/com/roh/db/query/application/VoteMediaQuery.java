package com.roh.db.query.application;

import com.roh.db.query.ApplicationQuery;

public class VoteMediaQuery implements ApplicationQuery {

	@Override
	public String getInsertQuery(int voteNum) {
		String preparedSql = "INSERT INTO vote_media(vote_num, pc, smart_phone, sms, on_site) " + "values(" + voteNum + " ,?, ?, ?, ?)";

		return preparedSql;
	}

	@Override
	public String getSelectQuery(int voteNum) {
		String preparedSql = "Select * from vote_media where vote_num = ";

		return preparedSql + voteNum + ";";
	}

	@Override
	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE vote_media set pc=?, smart_phone=?, sms =?, on_site=? where vote_num = " + voteNum + ";";

		return preparedSql;
	}

}
