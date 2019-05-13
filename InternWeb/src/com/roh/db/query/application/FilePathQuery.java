package com.roh.db.query.application;

import com.roh.db.query.ApplicationQuery;

public class FilePathQuery implements ApplicationQuery {

	@Override
	public String getInsertQuery(int voteNum) {
		String preparedSql = "INSERT INTO file_path(vote_num, regis_num_card, base_doc, manager_certify, pers_agreement, usage_agreement)" + "values("
				+ voteNum + " , ?, ?, ?, ?, ?)";

		return preparedSql;
	}

	@Override
	public String getSelectQuery(int voteNum) {
		String preparedSql = "Select * from file_path where vote_num = ";
		return preparedSql + voteNum;
	}

	@Override
	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE file_path set regis_num_card=?, base_doc=?, manager_certify =?, pers_agreement=?, usage_agreement=? where vote_num = "
				+ voteNum + ";";
		return preparedSql;
	}

}
