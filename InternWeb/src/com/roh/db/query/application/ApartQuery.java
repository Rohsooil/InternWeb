package com.roh.db.query.application;

import com.roh.db.query.ApplicationQuery;

public class ApartQuery implements ApplicationQuery {

	@Override
	public String getInsertQuery(int voteNum) {
		String preparedSql = "INSERT INTO apart(vote_num, apart_name, apart_type, register_num, rep_type, rep_name, apart_tel, apart_fax, apart_address)"
				+ "values(" + voteNum + " ,?, ?, ?, ?, ?, ?, ?, ?)";

		return preparedSql;
	}

	@Override
	public String getSelectQuery(int voteNum) {
		String preparedSql = "Select * from apart where vote_num = ";
		return preparedSql + voteNum;
	}

	@Override
	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE apart set apart_name=?, apart_type=?, register_num =?, rep_type=?, rep_name=?, apart_tel=?, apart_fax=?, apart_address=? where vote_num = "
				+ voteNum + ";";
		return preparedSql;
	}

}
