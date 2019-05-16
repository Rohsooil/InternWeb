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
import com.roh.service.ApplyService;

@WebServlet("/apply/application")
public class ApplicationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/applyForm.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			new ApplyService().doService(request);

			response.getWriter().print("Success");
		} catch (InputInvalidException | DateInvalidException e) {
			response.setCharacterEncoding("UTF-8");
			response.getWriter().print(e.getMessage());
		}

	}

}
