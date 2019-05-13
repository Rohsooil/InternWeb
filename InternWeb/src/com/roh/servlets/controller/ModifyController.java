package com.roh.servlets.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/apply/modify")
public class ModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Vote vote = (Vote) request.getAttribute("Vote");
//		VoteMedia voteMedia = (VoteMedia) request.getAttribute("Media");
//		Apartment apart = (Apartment) request.getAttribute("Apart");
//		Admin admin = (Admin) request.getAttribute("Admin");
//		FilePath filePath = (FilePath) request.getAttribute("FilePath");
//
//		DBModelAccessObject dbAccessObject = new DBModelAccessObject();
		doGet(request, response);
	}

}
