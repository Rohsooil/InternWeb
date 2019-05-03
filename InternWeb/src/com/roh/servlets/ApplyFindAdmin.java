package com.roh.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.db.AdminAccessObject;
import com.roh.db.DBConnector;

@WebServlet("/apply/findAdmin")
public class ApplyFindAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			DBConnector dbConnector = new DBConnector();
			Integer[] result = new AdminAccessObject().selectVoteNum(dbConnector, request.getParameter("admin_name"),
					request.getParameter("admin_phone"));
			
			response.getWriter().print(Arrays.toString(result));

			response.getWriter().close();
		} catch (SQLException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error/inputError.jsp");
			dispatcher.forward(request, response);
		}
	}

}
