package com.roh.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.exception.InputInvalidException;
import com.roh.helper.MappingHelper;

@WebServlet("/apply/application")
public class ApplicationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/applyForm.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MappingHelper helper = new MappingHelper(request);

			request.setAttribute("Vote", helper.getVote());
			request.setAttribute("Apart", helper.getApartment());
			request.setAttribute("Admin", helper.getAdmin());
			request.setAttribute("FilePath", helper.getFilePath());
			request.setAttribute("Media", helper.getVoteMedia());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/save");
			dispatcher.forward(request, response);

		} catch (InputInvalidException e) {
			request.setAttribute("Error", e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error/inputError.jsp");
			dispatcher.forward(request, response);
		}

	}

}
