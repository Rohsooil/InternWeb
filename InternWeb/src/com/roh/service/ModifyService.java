package com.roh.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.roh.db.accessor.ApplicationAccessor;
import com.roh.db.query.AdminQuery;
import com.roh.db.query.ApartQuery;
import com.roh.db.query.FilePathQuery;
import com.roh.db.query.VoteMediaQuery;
import com.roh.db.query.VoteQuery;
import com.roh.exception.DateInvalidException;
import com.roh.exception.InputInvalidException;
import com.roh.helper.MappingHelper;

public class ModifyService implements Service {

	public void doService(HttpServletRequest request) throws InputInvalidException, ServletException, DateInvalidException {
		int voteNum = Integer.parseInt(request.getPathInfo().replace("/", ""));

		MappingHelper helper = new MappingHelper(request.getParameterMap());

		ApplicationAccessor accessor = new ApplicationAccessor();

		accessor.update(new VoteQuery(), voteNum, helper.getVote());
		accessor.update(new VoteMediaQuery(), voteNum, helper.getVoteMedia());
		accessor.update(new ApartQuery(), voteNum, helper.getApartment());
		accessor.update(new AdminQuery(), voteNum, helper.getAdmin());
		accessor.update(new FilePathQuery(), voteNum, helper.getFilePath());
	}

}
