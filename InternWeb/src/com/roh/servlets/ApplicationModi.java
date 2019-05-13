package com.roh.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.db.ApplicationModelAccessor;
import com.roh.db.query.application.AdminQuery;
import com.roh.db.query.application.ApartQuery;
import com.roh.db.query.application.FilePathQuery;
import com.roh.db.query.application.VoteMediaQuery;
import com.roh.db.query.application.VoteQuery;
import com.roh.exception.InputInvalidException;
import com.roh.helper.MappingHelper;
import com.roh.model.application.Admin;
import com.roh.model.application.Apartment;
import com.roh.model.application.FilePath;
import com.roh.model.application.Vote;
import com.roh.model.application.VoteMedia;

@WebServlet("/apply/application/*")
public class ApplicationModi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getPathInfo().matches("/[0-9]+")) {

			int voteNum = Integer.parseInt(request.getPathInfo().replace("/", ""));

			ApplicationModelAccessor accessor = new ApplicationModelAccessor();

			Vote vote = (Vote) accessor.select(new VoteQuery().getSelectQuery(voteNum), Vote.class);
			VoteMedia voteMedia = (VoteMedia) accessor.select(new VoteMediaQuery().getSelectQuery(voteNum), VoteMedia.class);
			Admin admin = (Admin) accessor.select(new AdminQuery().getSelectQuery(voteNum), Admin.class);
			Apartment apartment = (Apartment) accessor.select(new ApartQuery().getSelectQuery(voteNum), Apartment.class);
			FilePath filePath = (FilePath) accessor.select(new FilePathQuery().getSelectQuery(voteNum), FilePath.class);

			request.setAttribute("vote", vote);
			request.setAttribute("voteMedia", voteMedia);
			request.setAttribute("admin", admin);
			request.setAttribute("apart", apartment);
			request.setAttribute("file", filePath);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/modifyForm.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendError(405);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MappingHelper helper = new MappingHelper(request);

			request.setAttribute("Vote", helper.getVote());
			request.setAttribute("Apart", helper.getApartment());
			request.setAttribute("Admin", helper.getAdmin());
			request.setAttribute("FilePath", helper.getFilePath());
			request.setAttribute("Media", helper.getVoteMedia());

			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/modify");
			dispatcher.forward(request, response);

		} catch (InputInvalidException e) {
			request.setAttribute("Error", e);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error/inputError.jsp");
			dispatcher.forward(request, response);
		}
	}

}
