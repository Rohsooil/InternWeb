package com.roh.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.dao.DataAccessObject;

@WebServlet("/apply/findAdmin")
public class ApplyFindAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request);
		DataAccessObject dao = new DataAccessObject();
		int isExist = dao.isVoteAdmin(request.getParameter("admin_name"), request.getParameter("admin_phone"));
		if (isExist == 1) {
			response.getWriter().write("true");
		} else {
			response.getWriter().print("false");
		}
		response.getWriter().close();
	}

}
