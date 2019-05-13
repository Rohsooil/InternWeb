package com.roh.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.servlet.ServletException;

import com.roh.db.accessor.DBAccessor;

public class VoteNumAccessor implements DBAccessor {

	public Integer[] select(String adminName, String adminPhone) throws ServletException {
		String sql = "SELECT vote_num FROM `admin` WHERE admin_name = ? AND admin_phone = ?";
		Integer[] result = null;
		try {
			PreparedStatement pstmt = new DBConnector().getPreparedStatement(sql);

			pstmt.setString(1, adminName);
			pstmt.setString(2, adminPhone);

			ResultSet resultSet = pstmt.executeQuery();
			HashSet<Integer> hs = new HashSet<>();
			// System.out.println(rs.getArray(1));
			int index = 1;
			while (resultSet.next()) {
				hs.add(resultSet.getInt(index));
			}
			resultSet.close();
			result = hs.toArray(new Integer[hs.size()]);

			close(pstmt.getConnection(), pstmt, resultSet);
		} catch (SQLException e) {
			throw new ServletException(e);
		}

		return result;
	}
}
