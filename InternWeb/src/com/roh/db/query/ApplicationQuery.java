package com.roh.db.query;

public interface ApplicationQuery {

	String getSelectQuery(int voteNum);

	String getUpdateQuery(int voteNum);

	default String getInsertQuery() {
		return null;
	}

	default String getInsertQuery(int voteNum) {
		return null;
	}

}
