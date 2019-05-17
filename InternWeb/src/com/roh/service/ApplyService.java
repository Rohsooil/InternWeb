package com.roh.service;

import java.sql.PreparedStatement;

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

public class ApplyService implements Service {

	public void doService(HttpServletRequest request) throws InputInvalidException, ServletException, DateInvalidException {
		MappingHelper helper = new MappingHelper(request.getParameterMap());

		ApplicationDBAccessor accessor = new ApplicationDBAccessor();

		Vote vote = helper.getVote();
		VoteMedia voteMedia = helper.getVoteMedia();
		Apartment apartment = helper.getApartment();
		Admin admin = helper.getAdmin();
		FilePath filePath = helper.getFilePath();

		int voteNum = accessor.insert(new VoteQuery(), vote, PreparedStatement.RETURN_GENERATED_KEYS);

		accessor.insert(new VoteMediaQuery(), voteNum, voteMedia);
		accessor.insert(new ApartQuery(), voteNum, apartment);
		accessor.insert(new AdminQuery(), voteNum, admin);
		accessor.insert(new FilePathQuery(), voteNum, filePath);
	}

}
