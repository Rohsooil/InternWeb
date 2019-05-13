package com.roh.helper;

import java.lang.reflect.Field;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.roh.beans.Date;
import com.roh.exception.InputInvalidException;
import com.roh.model.application.Admin;
import com.roh.model.application.Apartment;
import com.roh.model.application.FilePath;
import com.roh.model.application.Vote;
import com.roh.model.application.VoteMedia;
import com.roh.validation.Validator;

public class MappingHelper {
	private HttpServletRequest request;
	private Validator validator;

	public MappingHelper(HttpServletRequest request) {
		this.request = request;
		this.validator = new Validator();
	}

	public Vote getVote() throws InputInvalidException {

		String title = validator.getSafeString("투표 제목", request.getParameter("vote_title"));
		String type = validator.getSafeString("투표 유형", request.getParameter("vote_type"));
		int estimate = validator.getSafeInt("예상 투표자 수", request.getParameter("vote_estimate"));
		Date startDay = validator.getSafeDate("투표 시작일", request.getParameter("voteStartDate"));
		Date endDay = validator.getSafeDate("투표 종료일", request.getParameter("voteEndDate"));

		return new Vote(title, type, estimate, startDay, endDay);
	}

	public VoteMedia getVoteMedia() throws InputInvalidException {
		String[] mediaArr = validator.getSafeMedia("투표 매체", request.getParameterValues(("vote_media")));
		VoteMedia voteMedia = new VoteMedia();
		Field[] fieldArr = voteMedia.getClass().getDeclaredFields();

		for (int i = 0; i < fieldArr.length; i++) {
			if (Arrays.stream(mediaArr).anyMatch(fieldArr[i].getName()::equals)) {
				voteMedia.setMember(i + 1, 1);
			}
		}

		return voteMedia;
	}

	public Admin getAdmin() throws InputInvalidException {

		String type = validator.getSafeString("관리자 구분", request.getParameter("admin_type"));
		String name = validator.getSafeString("관리자 이름", request.getParameter("admin_name"));
		String rank = validator.getSafeString("관리자 직위", request.getParameter("admin_rank"));
		String tel = validator.getSafeString("연락처(유선)", request.getParameter("admin_tel"));
		String phone = validator.getSafeString("연락처(무선)", request.getParameter("admin_phone"));
		String email = validator.getSafeString("이메일 주소", request.getParameter("admin_email"));

		return new Admin(type, name, rank, tel, phone, email);
	}

	public Apartment getApartment() throws InputInvalidException {

		String apartName = validator.getSafeString("아파트 명", request.getParameter("apart_name"));
		String apartType = validator.getSafeString("아파트 구분", request.getParameter("apart_type"));
		String registerNum = validator.getSafeString("사업자 등록번호", request.getParameter("register_num"));
		String repType = validator.getSafeString("대표자 구분", request.getParameter("rep_type"));
		String repName = validator.getSafeString("대표자 성명", request.getParameter("rep_name"));
		String tel = validator.getSafeString("아파트 연락처", request.getParameter("apart_tel"));
		String fax = validator.getSafeString("팩스", request.getParameter("apart_fax"));
		String address = validator.getSafeString("아파트 소재지", request.getParameter("apart_address"));

		return new Apartment(apartName, apartType, registerNum, repName, repType, tel, fax, address);
	}

	public FilePath getFilePath() throws InputInvalidException {

		String regisNumCardPath = validator.getSafeString("고유번호증", request.getParameter("regisNumCardPath"));
		String baseDocPath = validator.getSafeString("투표신청 근거서류", request.getParameter("baseDocPath"));
		String managerCertifyPath = validator.getSafeString("관리소장 직인 및 배치신고 증명서", request.getParameter("managerCertifyPath"));
		String persAgreementPath = validator.getSafeString("개인정보수집 동의서", request.getParameter("persAgreementPath"));
		String usageAgreementPath = validator.getSafeString("이용협약서", request.getParameter("usageAgreementPath"));

		return new FilePath(regisNumCardPath, baseDocPath, managerCertifyPath, persAgreementPath, usageAgreementPath);
	}
}
