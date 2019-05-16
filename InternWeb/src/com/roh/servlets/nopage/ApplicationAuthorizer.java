package com.roh.servlets.nopage;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.db.accessor.VoteNumAccessor;

@WebServlet("/apply/auth")
public class ApplicationAuthorizer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Integer[] result = new VoteNumAccessor().select(request.getParameter("admin_name"), request.getParameter("admin_phone"));
		
		response.getWriter().print(Arrays.toString(result));
		response.getWriter().close();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(405);
	}
}
