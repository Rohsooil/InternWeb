package com.roh.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.roh.db.accessor.ApplicationDBAccessor;
import com.roh.db.query.AdminQuery;
import com.roh.db.query.ApartQuery;
import com.roh.db.query.FilePathQuery;
import com.roh.db.query.VoteMediaQuery;
import com.roh.db.query.VoteQuery;
import com.roh.model.application.Admin;
import com.roh.model.application.Apartment;
import com.roh.model.application.FilePath;
import com.roh.model.application.Vote;
import com.roh.model.application.VoteMedia;

public class SelectService implements Service {

	public void doService(HttpServletRequest request) throws ServletException {
		int voteNum = Integer.parseInt(request.getPathInfo().replace("/", ""));

		ApplicationDBAccessor accessor = new ApplicationDBAccessor();

		Vote vote = (Vote) accessor.select(new VoteQuery(), voteNum, Vote.class);
		VoteMedia voteMedia = (VoteMedia) accessor.select(new VoteMediaQuery(), voteNum, VoteMedia.class);
		Admin admin = (Admin) accessor.select(new AdminQuery(), voteNum, Admin.class);
		Apartment apartment = (Apartment) accessor.select(new ApartQuery(), voteNum, Apartment.class);
		FilePath filePath = (FilePath) accessor.select(new FilePathQuery(), voteNum, FilePath.class);

		request.setAttribute("vote", vote);
		request.setAttribute("voteMedia", voteMedia);
		request.setAttribute("admin", admin);
		request.setAttribute("apart", apartment);
		request.setAttribute("file", filePath);
	}
}
