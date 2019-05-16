package com.roh.service;

import java.sql.PreparedStatement;

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

public class ApplyService implements Service {

	public void doService(HttpServletRequest request) throws InputInvalidException, ServletException, DateInvalidException {
		MappingHelper helper = new MappingHelper(request.getParameterMap());

		ApplicationAccessor accessor = new ApplicationAccessor();

		int voteNum = accessor.insert(new VoteQuery(), helper.getVote(), PreparedStatement.RETURN_GENERATED_KEYS);

		accessor.insert(new VoteMediaQuery(), voteNum, helper.getVoteMedia());
		accessor.insert(new ApartQuery(), voteNum, helper.getApartment());
		accessor.insert(new AdminQuery(), voteNum, helper.getAdmin());
		accessor.insert(new FilePathQuery(), voteNum, helper.getFilePath());
	}

}
