package com.roh.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.roh.db.accessor.ApplicationDBAccessor;
import com.roh.db.query.AdminQuery;
import com.roh.db.query.ApartQuery;
import com.roh.db.query.FilePathQuery;
import com.roh.db.query.VoteMediaQuery;
import com.roh.db.query.VoteQuery;
import com.roh.exception.DateInvalidException;
import com.roh.exception.InputInvalidException;
import com.roh.helper.MappingHelper;
import com.roh.model.application.Admin;
import com.roh.model.application.Apartment;
import com.roh.model.application.FilePath;
import com.roh.model.application.Vote;
import com.roh.model.application.VoteMedia;

public class ModifyService implements Service {

	public void doService(HttpServletRequest request) throws InputInvalidException, ServletException, DateInvalidException {
		int voteNum = Integer.parseInt(request.getPathInfo().replace("/", ""));

		MappingHelper helper = new MappingHelper(request.getParameterMap());

		Vote vote = helper.getVote();
		VoteMedia voteMedia = helper.getVoteMedia();
		Apartment apartment = helper.getApartment();
		Admin admin = helper.getAdmin();
		FilePath filePath = helper.getFilePath();

		ApplicationDBAccessor accessor = new ApplicationDBAccessor();

		accessor.update(new VoteQuery(), voteNum, vote);
		accessor.update(new VoteMediaQuery(), voteNum, voteMedia);
		accessor.update(new ApartQuery(), voteNum, apartment);
		accessor.update(new AdminQuery(), voteNum, admin);
		accessor.update(new FilePathQuery(), voteNum, filePath);
	}

}
