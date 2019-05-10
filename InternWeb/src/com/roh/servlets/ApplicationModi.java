package com.roh.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/apply/modify/*")
public class ApplicationModi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getPathInfo().matches("/[0-9]+")) {
//			DBAccessObject accessObject = new DBAccessObject();
//
//			DBConnector dbConnector = new DBConnector();
//			int voteNum = Integer.parseInt(request.getPathInfo().replace("/", ""));
//			// Vote vote = new VoteAccessObject().select(dbConnector, voteNum);
//
//			Vote vote = (Vote) accessObject.select(new VoteQueryMaker().getSelectQuery(voteNum), Vote.class);
//			vote.setMedia(new VoteMediaQueryMaker().select(dbConnector, voteNum));
//			Admin admin = (Admin) accessObject.select(new AdminQueryMaker().getSelectQuery(voteNum), Admin.class);
//			Apartment apartment = (Apartment) accessObject.select(new ApartQueryMaker().getSelectQuery(voteNum), Apartment.class);
//			FilePath filePath = (FilePath) accessObject.select(new FilePathQueryMaker().getSelectQuery(voteNum), FilePath.class);
//
//			request.setAttribute("vote", vote);
//			request.setAttribute("admin", admin);
//			request.setAttribute("apart", apartment);
//			request.setAttribute("file", filePath);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/modifyForm.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendError(405);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
