package com.roh.db.query;

public interface Query {
	default String getSelectQuery() {
		return null;
	}

	default String getInsertQuery() {
		return null;
	}

	default String getUpdateQuery() {
		return null;
	}
}
