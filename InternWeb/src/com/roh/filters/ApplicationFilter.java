package com.roh.filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.roh.db.AdminAccessObject;
import com.roh.db.ApartAccessObject;
import com.roh.db.DBConnector;
import com.roh.db.VoteAccessObject;
import com.roh.db.VoteMediaAccessObject;
import com.roh.model.Admin;
import com.roh.model.Apartment;
import com.roh.model.Vote;

@WebFilter("/apply/application")
public class ApplicationFilter implements Filter {

	public ApplicationFilter() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		if (request.getParameter("id") != null) {

			try {
				DBConnector dbConnector = new DBConnector();

				// DataAccessObject dao = new DataAccessObject();
				int voteNum = Integer.parseInt(request.getParameter("id"));
				Vote vote = new VoteAccessObject().select(dbConnector, voteNum);
				vote.setMedia(new VoteMediaAccessObject().select(dbConnector, voteNum));
				Admin admin = new AdminAccessObject().select(dbConnector, voteNum);
				Apartment apartment = new ApartAccessObject().select(dbConnector, voteNum);

//			Vote vote = dao.selectVote(voteNum);
//			vote.setMedia(dao.selectVoteMedia(voteNum));
//			Admin admin = dao.selectAdmin(voteNum);
//			Apartment apartment = dao.selectApartment(voteNum);

				request.setAttribute("vote", vote);
				request.setAttribute("admin", admin);
				request.setAttribute("apart", apartment);
			} catch (SQLException e) {

			}

		}
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
