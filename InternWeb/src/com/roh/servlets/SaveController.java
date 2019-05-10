package com.roh.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.db.DBAccessObject;
import com.roh.db.query.AdminQueryMaker;
import com.roh.db.query.ApartQueryMaker;
import com.roh.db.query.FilePathQueryMaker;
import com.roh.db.query.VoteMediaQueryMaker;
import com.roh.db.query.VoteQueryMaker;
import com.roh.model.Admin;
import com.roh.model.Apartment;
import com.roh.model.FilePath;
import com.roh.model.Vote;
import com.roh.model.VoteMedia;

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

		DBAccessObject dbAccessObject = new DBAccessObject();
		int voteNum = dbAccessObject.insert(new VoteQueryMaker().getInsertQuery(), vote, PreparedStatement.RETURN_GENERATED_KEYS);
		dbAccessObject.insert(new VoteMediaQueryMaker().getInsertQuery(voteNum), voteMedia);
		dbAccessObject.insert(new ApartQueryMaker().getInsertQuery(voteNum), apart);
		dbAccessObject.insert(new AdminQueryMaker().getInsertQuery(voteNum), admin);
		dbAccessObject.insert(new FilePathQueryMaker().getInsertQuery(voteNum), filePath);

		if (voteNum > 0) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/applySuccess.jsp");
			dispatcher.forward(request, response);
		}

	}

}
