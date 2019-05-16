package com.roh.db.query;

public class FilePathQuery implements ApplicationQuery {

	public String getInsertQuery(int voteNum) {
		String preparedSql = "INSERT INTO file_path(vote_num, regisNumCard, baseDoc, managerCertify, persAgreement, usageAgreement)" + "values("
				+ voteNum + " , ?, ?, ?, ?, ?)";

		return preparedSql;
	}

	public String getSelectQuery(int voteNum) {
		String preparedSql = "Select regisNumCard, baseDoc, managerCertify, persAgreement, usageAgreement from file_path where vote_num = ";
		return preparedSql + voteNum + ";";
	}

	public String getUpdateQuery(int voteNum) {
		String preparedSql = "UPDATE file_path set regisNumCard=?, baseDoc=?, managerCertify =?, persAgreement=?, usageAgreement=? where vote_num = ";
		return preparedSql + voteNum + ";";
	}

}
