package com.roh.db.accessor;

import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.roh.db.query.ApplicationQuery;
import com.roh.helper.ModelMethodCaller;
import com.roh.model.application.ApplicationModel;

public class ApplicationAccessor extends DBAccessor {

	public void insert(ApplicationQuery query, int voteNum, ApplicationModel model) throws ServletException {
		execute(query.getInsertQuery(voteNum), model);
	}

	public void update(ApplicationQuery query, int voteNum, ApplicationModel model) throws ServletException {
		execute(query.getUpdateQuery(voteNum), model);
	}

	public int insert(ApplicationQuery query, ApplicationModel model, int flag) throws ServletException {
		int result = 0;
		try {
			PreparedStatement pstmt = getPreparedStatement(query.getInsertQuery(), flag);
			ParameterMetaData pmd = pstmt.getParameterMetaData();

			ModelMethodCaller caller = new ModelMethodCaller();

			for (int i = 1; i <= pmd.getParameterCount(); i++) {
				pstmt.setString(i, caller.callGetter(model, i));
			}

			pstmt.executeUpdate();

			ResultSet resultSet = pstmt.getGeneratedKeys();
			result = (resultSet.next()) ? resultSet.getInt(1) : 0;

			close(pstmt.getConnection(), pstmt, resultSet);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		return result;
	}

	public ApplicationModel select(ApplicationQuery query, int voteNum, Class<? extends ApplicationModel> cls) throws ServletException {
		ApplicationModel model = null;

		try {
			model = cls.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}

		try {
			PreparedStatement pstmt = getPreparedStatement(query.getSelectQuery(voteNum));

			ResultSet resultSet = pstmt.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			ModelMethodCaller caller = new ModelMethodCaller();

			if (resultSet.next()) {
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					String colLabel = rsmd.getColumnLabel(i);
					caller.callSetter(model, colLabel, resultSet.getString(colLabel));
				}
			}

			close(pstmt.getConnection(), pstmt, resultSet);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
		return model;
	}

	private void execute(String sql, ApplicationModel model) throws ServletException {
		try {
			PreparedStatement pstmt = getPreparedStatement(sql);
			ParameterMetaData pmd = pstmt.getParameterMetaData();

			ModelMethodCaller caller = new ModelMethodCaller();

			for (int i = 1; i <= pmd.getParameterCount(); i++) {
				pstmt.setString(i, caller.callGetter(model, i));
			}

			pstmt.executeUpdate();

			close(pstmt.getConnection(), pstmt, null);
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}

}
