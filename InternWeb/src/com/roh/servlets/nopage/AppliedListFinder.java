package com.roh.servlets.nopage;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.db.accessor.AppliedVoteAccessor;
import com.roh.model.AppliedVote;

@WebServlet("/apply/find")
public class AppliedListFinder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] voteNumArray = request.getParameter("vote_num").split(",");
		AppliedVote[] appliedVotes = new AppliedVote[voteNumArray.length];

		AppliedVoteAccessor accessor = new AppliedVoteAccessor();
		for (int i = 0; i < voteNumArray.length; i++) {
			appliedVotes[i] = accessor.select(Integer.parseInt(voteNumArray[i]));
			request.getSession().setAttribute(voteNumArray[i], "authorized");
		}
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(Arrays.toString(appliedVotes));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendError(405);
	}

}
