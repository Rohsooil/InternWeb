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
import com.roh.model.Admin;
import com.roh.model.Apartment;
import com.roh.model.FilePath;
import com.roh.model.Vote;
import com.roh.model.VoteMedia;

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

			Vote vote = helper.getVote();
			Apartment apart = helper.getApartment();
			Admin admin = helper.getAdmin();
			FilePath filePath = helper.getFilePath();
			VoteMedia voteMedia = helper.getVoteMedia();

			request.setAttribute("Vote", vote);
			request.setAttribute("Apart", apart);
			request.setAttribute("Admin", admin);
			request.setAttribute("FilePath", filePath);
			request.setAttribute("Media", voteMedia);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/save");
			dispatcher.forward(request, response);

		} catch (InputInvalidException e) {
			request.setAttribute("Error", e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error/inputError.jsp");
			dispatcher.forward(request, response);
		}

	}

}
