package com.roh.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.roh.dao.DataAccessObject;
import com.roh.model.Admin;
import com.roh.model.Apartment;
import com.roh.model.FilePath;
import com.roh.model.Vote;

@WebServlet("/apply/application")
public class ApplyForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/applyForm.jsp");

		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Vote vote = new Vote();
		vote.setTitle(request.getParameter("vote_title"));
		vote.setType(Integer.parseInt(request.getParameter("vote_type")));
		vote.setEstimate(Integer.parseInt(request.getParameter("vote_estimate")));
		vote.setStartDay(request.getParameter("voteBeginDate"));
		vote.setEndDay(request.getParameter("voteEndDate"));
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

		FilePath filePath = new FilePath();
		filePath.setRegisNumCardPath(request.getParameter("regisNumCardPath"));
		filePath.setBaseDocPath(request.getParameter("baseDocPath"));
		filePath.setManagerCertifyPath(request.getParameter("managerCertifyPath"));
		filePath.setPersAgreementPath(request.getParameter("persAgreementPath"));
		filePath.setUsageAgreementPath(request.getParameter("usageAgreementPath"));

		DataAccessObject dao = new DataAccessObject();
		int vote_num = dao.insertVote(vote);
		int secondRowCount = 0;
		secondRowCount = dao.insertVoteMedia(vote_num, vote.getMedia());

		int adminRowCount = dao.insertVoteAdmin(vote_num, admin);

		int apartRowCount = dao.insertVoteApart(vote_num, apart);

		int fileRowCount = dao.insertVoteFilePath(vote_num, filePath);

		if (vote_num != 0) {
			System.out.println("succes");
		} else {
			System.out.println("fail");
		}
		if (secondRowCount == 1) {
			System.out.println("Second succes");
		} else {
			System.out.println("Second fail");
		}
		if (adminRowCount == 1) {
			System.out.println("Third succes");
		} else {
			System.out.println("Third fail");
		}

		if (apartRowCount == 1) {
			System.out.println("fourth succes");
		} else {
			System.out.println("fourth fail");
		}

		if (fileRowCount == 1) {
			System.out.println("last succes");
		} else {
			System.out.println("last fail");
		}

		if (fileRowCount == 1) {
			System.out.println("Last succes");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/apply/applySuccess.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("Last fail");
			response.sendRedirect(request.getContextPath() + "/apply/application");
		}

	}

}
