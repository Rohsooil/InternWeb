package com.roh.servlets;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.db.DataAccessObject;
import com.roh.dto.VoteDTO;

@WebServlet("/apply/applicationList")
public class ApplicationList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] voteNumArray = request.getParameter("vote_num").split(",");
		VoteDTO[] voteDatas = new VoteDTO[voteNumArray.length];
		DataAccessObject dao = new DataAccessObject();
		for (int i = 0; i < voteNumArray.length; i++) {
			voteDatas[i] = dao.findAppliedVote(Integer.parseInt(voteNumArray[i]));
			request.getSession().setAttribute(voteNumArray[i], "authorized");
		}
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(Arrays.toString(voteDatas));
	}

}
