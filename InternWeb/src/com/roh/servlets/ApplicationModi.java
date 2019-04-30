package com.roh.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.beans.Date;
import com.roh.db.DataAccessObject;
import com.roh.model.Admin;
import com.roh.model.Apartment;
import com.roh.model.Vote;

@WebServlet("/apply/modify")
public class ApplicationModi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(405);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int vote_num = Integer.parseInt(request.getParameter("vote_num"));

		Vote vote = new Vote();
		vote.setTitle(request.getParameter("vote_title"));
		vote.setType(Integer.parseInt(request.getParameter("vote_type")));
		vote.setEstimate(Integer.parseInt(request.getParameter("vote_estimate")));
		vote.setStartDay(new Date(request.getParameter("voteBeginDate")));
		vote.setEndDay(new Date(request.getParameter("voteEndDate")));
		vote.setMedia(request.getParameterValues(("vote_media")));

		Admin admin = new Admin();
		admin.setType(Integer.parseInt(request.getParameter("admin_type")));
		admin.setName(request.getParameter("admin_name"));
		admin.setRank(request.getParameter("admin_rank"));
		admin.setTel(request.getParameter("admin_tel"));
		admin.setPhone(request.getParameter("admin_phone"));
		admin.setEmail(request.getParameter("admin_email"));

		Apartment apart = new Apartment();
		apart.setApartName(request.getParameter("apart_name"));
		apart.setApartType(Integer.parseInt(request.getParameter("apart_type")));
		apart.setRegisterNum(request.getParameter("register_num"));
		apart.setRepType(Integer.parseInt(request.getParameter("rep_type")));
		apart.setRepName(request.getParameter("rep_name"));
		apart.setTel(request.getParameter("apart_tel"));
		apart.setFax(request.getParameter("apart_fax"));
		apart.setAddress(request.getParameter("apart_address"));

//		FilePath filePath = new FilePath();
//		filePath.setRegisNumCardPath(request.getParameter("regisNumCardPath"));
//		filePath.setBaseDocPath(request.getParameter("baseDocPath"));
//		filePath.setManagerCertifyPath(request.getParameter("managerCertifyPath"));
//		filePath.setPersAgreementPath(request.getParameter("persAgreementPath"));
//		filePath.setUsageAgreementPath(request.getParameter("usageAgreementPath"));

		DataAccessObject dao = new DataAccessObject();
		int first = dao.updateVote(vote_num, vote);
		int second = dao.updateVoteMedia(vote_num, vote.getMedia());
		int thrid = dao.updateAdmin(vote_num, admin);
		int fourth = dao.updateApart(vote_num, apart);

		if (first == 1) {
			System.out.println("first succes");
		} else {
			System.out.println("First fail");
		}
		if (second == 1) {
			System.out.println("Second succes");
		} else {
			System.out.println("Second fail");
		}
		if (thrid == 1) {
			System.out.println("Third succes");
		} else {
			System.out.println("Third fail");
		}

		if (fourth == 1) {
			System.out.println("fourth succes");
		} else {
			System.out.println("fourth fail");
		}

		if (fourth == 1) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/applySuccess.jsp");
			dispatcher.forward(request, response);
		}

//		if (fileRowCount == 1) {
//			System.out.println("last succes");
//		} else {
//			System.out.println("last fail");
//		}
		// doGet(request, response);
	}

}
