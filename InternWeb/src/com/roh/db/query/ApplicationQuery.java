package com.roh.db.query;

public interface ApplicationQuery extends Query {
	default String getSelectQuery(int voteNum) {
		return null;
	}

	default String getInsertQuery(int voteNum) {
		return null;
	}

	default String getUpdateQuery(int voteNum) {
		return null;
	}
}
