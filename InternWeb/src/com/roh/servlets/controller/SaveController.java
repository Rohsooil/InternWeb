package com.roh.servlets.controller;

import java.io.IOException;
import java.sql.PreparedStatement;

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
import com.roh.model.application.Admin;
import com.roh.model.application.Apartment;
import com.roh.model.application.FilePath;
import com.roh.model.application.Vote;
import com.roh.model.application.VoteMedia;

@WebServlet("/apply/save")
public class SaveController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Vote vote = (Vote) request.getAttribute("Vote");
		VoteMedia voteMedia = (VoteMedia) request.getAttribute("Media");
		Apartment apart = (Apartment) request.getAttribute("Apart");
		Admin admin = (Admin) request.getAttribute("Admin");
		FilePath filePath = (FilePath) request.getAttribute("FilePath");

		ApplicationModelAccessor dbAccessObject = new ApplicationModelAccessor();
		int voteNum = dbAccessObject.insert(new VoteQuery().getInsertQuery(), vote, PreparedStatement.RETURN_GENERATED_KEYS);
		dbAccessObject.insert(new VoteMediaQuery().getInsertQuery(voteNum), voteMedia);
		dbAccessObject.insert(new ApartQuery().getInsertQuery(voteNum), apart);
		dbAccessObject.insert(new AdminQuery().getInsertQuery(voteNum), admin);
		dbAccessObject.insert(new FilePathQuery().getInsertQuery(voteNum), filePath);

		if (voteNum > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/applySuccess.jsp");
			dispatcher.forward(request, response);
		}

	}

}
