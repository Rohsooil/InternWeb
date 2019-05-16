package com.roh.db.query;

public class ApartQuery implements ApplicationQuery {

	public String getInsertQuery(int voteNum) {
		String preparedSql = "INSERT INTO apart(vote_num, name, type, registerNum, repType, repName, tel, fax, address) values(" + voteNum
				+ " ,?, ?, ?, ?, ?, ?, ?, ?)";

		return preparedSql;
	}

	public String getSelectQuery(int voteNum) {
		String preparedSql = "Select name, type, registerNum, repType, repName, tel, fax, address from apart where vote_num = ";
		return preparedSql + voteNum + ";";
	}

	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE apart set name=?, type=?, registerNum =?, repType=?, repName=?, tel=?, fax=?, address=? where vote_num = ";
		return preparedSql + voteNum + ";";
	}

}
