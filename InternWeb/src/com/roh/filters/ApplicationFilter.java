package com.roh.filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.roh.db.AdminAccessObject;
import com.roh.db.ApartAccessObject;
import com.roh.db.DBConnector;
import com.roh.db.FilePathAccessObject;
import com.roh.db.VoteAccessObject;
import com.roh.db.VoteMediaAccessObject;
import com.roh.model.Admin;
import com.roh.model.Apartment;
import com.roh.model.FilePath;
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

				int voteNum = Integer.parseInt(request.getParameter("id"));
				Vote vote = new VoteAccessObject().select(dbConnector, voteNum);
				vote.setMedia(new VoteMediaAccessObject().select(dbConnector, voteNum));
				Admin admin = new AdminAccessObject().select(dbConnector, voteNum);
				Apartment apartment = new ApartAccessObject().select(dbConnector, voteNum);
				FilePath filePath = new FilePathAccessObject().select(dbConnector, voteNum);

				request.setAttribute("vote", vote);
				request.setAttribute("admin", admin);
				request.setAttribute("apart", apartment);
				request.setAttribute("file", filePath);
			} catch (SQLException e) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/error/requestError.jsp");
				dispatcher.forward(request, response);
			}

		}
		
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
