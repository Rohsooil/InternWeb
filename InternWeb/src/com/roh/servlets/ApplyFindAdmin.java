package com.roh.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.db.DataAccessObject;

@WebServlet("/apply/findAdmin")
public class ApplyFindAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DataAccessObject dao = new DataAccessObject();
		//int voteNum = dao.findVoteNum(request.getParameter("admin_name"), request.getParameter("admin_phone"));
		Integer[] result = dao.findVoteNum(request.getParameter("admin_name"), request.getParameter("admin_phone"));
		//System.out.println(voteNum);
		response.getWriter().print(Arrays.toString(result));

		response.getWriter().close();

	}

}
