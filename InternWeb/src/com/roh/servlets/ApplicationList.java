package com.roh.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.db.DBConnector;
import com.roh.db.query.VoteQueryMaker;
import com.roh.dto.VoteDTO;

@WebServlet("/apply/applicationList")
public class ApplicationList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String[] voteNumArray = request.getParameter("vote_num").split(",");
			VoteDTO[] voteDatas = new VoteDTO[voteNumArray.length];

			DBConnector dbConnector = new DBConnector();
			VoteQueryMaker vao = new VoteQueryMaker();
			for (int i = 0; i < voteNumArray.length; i++) {
				voteDatas[i] = vao.selectAppliedVote(dbConnector, Integer.parseInt(voteNumArray[i]));
				request.getSession().setAttribute(voteNumArray[i], "authorized");
			}
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(Arrays.toString(voteDatas));
		} catch (SQLException e) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/error/inputError.jsp");
			dispatcher.forward(request, response);
		}
	}

}
