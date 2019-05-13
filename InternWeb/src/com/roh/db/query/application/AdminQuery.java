package com.roh.db.query.application;

import com.roh.db.query.ApplicationQuery;

public class AdminQuery implements ApplicationQuery {

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

}
