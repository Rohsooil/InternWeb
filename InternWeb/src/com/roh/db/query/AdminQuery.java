package com.roh.db.query;

public class AdminQuery implements ApplicationQuery {

	public String getInsertQuery(int voteNum) {
		String preparedSql = "INSERT INTO `admin`(vote_num, type, name, position, tel, phone, email)" + "values(" + voteNum + " ,?, ?, ?, ?, ?, ?)";

		return preparedSql + ";";
	}

	public String getSelectQuery(int voteNum) {
		String preparedSql = "SELECT type, name, position, tel, phone, email from `admin` where vote_num = ";
		return preparedSql + voteNum + ";";
	}

	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE `admin` set type=?, name=?, position=?, tel=?, phone=?, email=? where vote_num = " + voteNum + ";";
		return preparedSql;
	}

}
