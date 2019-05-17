package com.roh.servlets.page;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.exception.DateInvalidException;
import com.roh.exception.InputInvalidException;
import com.roh.service.ModifyService;
import com.roh.service.SelectService;

@WebServlet("/apply/application/*")
public class ApplicationModi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo().replace("/", "");

		if (request.getSession().getAttribute(path) == null) {
			response.sendError(405);
		} else if (request.getPathInfo().matches("/[0-9]+")) {
			new SelectService().doService(request);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/applyForm.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendError(405);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getPathInfo().replace("/", "");

		if (request.getSession().getAttribute(path) == null) {
			response.sendError(405);
		} else if (request.getPathInfo().matches("/[0-9]+")) {
			try {
				new ModifyService().doService(request);

				response.getWriter().print("Success");
			} catch (InputInvalidException | DateInvalidException e) {
				response.setCharacterEncoding("UTF-8");
				response.getWriter().print(e.getMessage());
			}

		} else {
			response.sendError(405);
		}

	}
}