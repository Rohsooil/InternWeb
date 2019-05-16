package com.roh.helper;

import java.util.Map;

import javax.servlet.ServletException;

import com.roh.exception.DateInvalidException;
import com.roh.exception.InputInvalidException;
import com.roh.forms.Date;
import com.roh.forms.Email;
import com.roh.forms.TelePhone;
import com.roh.model.application.Admin;
import com.roh.model.application.Apartment;
import com.roh.model.application.FilePath;
import com.roh.model.application.Vote;
import com.roh.model.application.VoteMedia;
import com.roh.validator.ModelValidator;
import com.roh.validator.data.DateValidator;

public class MappingHelper {

	private final int MAX_TITLE_LENGTH = 30;
	private final int MAX_NAME_LEGTH = 10;
	private final int MAX_TYPE_LEGTH = 13;
	private final int MAX_ADDRESS_LEGTH = 13;
	private final int MAX_FILE_LEGTH = 250;

	private Map<String, String[]> parameterMap;
	private ModelValidator validator;

	public MappingHelper(Map<String, String[]> parameterMap) {
		this.parameterMap = parameterMap;
		this.validator = new ModelValidator();
	}

	public Vote getVote() throws InputInvalidException, DateInvalidException {
		DateValidator dateValidator = new DateValidator();

		String title = validator.getSafeString("투표 제목", parameterMap.get("vote_title")[0], MAX_TITLE_LENGTH);
		String type = validator.getSafeString("투표 유형", parameterMap.get("vote_type")[0], MAX_TYPE_LEGTH);
		int estimate = validator.getSafeInt("예상 투표자 수", parameterMap.get("vote_estimate")[0]);

		Date startDate = validator.getSafeDate("투표 시작일", parameterMap.get("vote_startDate")[0]);
		Date endDate = validator.getSafeDate("투표 종료일", parameterMap.get("vote_endDate")[0]);

		if (dateValidator.isAfter(startDate, new Date())) {
			throw new DateInvalidException("투표 시작날짜가 오늘보다 이전입니다.");
		} else if (dateValidator.isAfter(endDate, startDate)) {
			throw new DateInvalidException("투표 종료날짜가 시작날짜보다 이전입니다.");
		} else if (!dateValidator.isRigthDate(startDate, endDate)) {
			throw new DateInvalidException("투표시작 날짜와 투표종료 날짜는 최대 3일 입니다.");
		}

		return new Vote(title, type, estimate, startDate, endDate);
	}

	public VoteMedia getVoteMedia() throws InputInvalidException, ServletException {
		String[] mediaArr = validator.getSafeMedia("투표 매체", parameterMap.get("vote_media"));
		VoteMedia voteMedia = new VoteMedia();
		ModelMethodCaller caller = new ModelMethodCaller();

		for (String media : mediaArr) {
			caller.callSetter(voteMedia, media, "1");
		}

		return voteMedia;
	}

	public Admin getAdmin() throws InputInvalidException {

		String type = validator.getSafeString("관리자 구분", parameterMap.get("admin_type")[0], MAX_TYPE_LEGTH);
		String name = validator.getSafeString("관리자 이름", parameterMap.get("admin_name")[0], MAX_NAME_LEGTH);
		String position = validator.getSafeString("관리자 직위", parameterMap.get("admin_position")[0], MAX_TYPE_LEGTH);
		TelePhone tel = validator.getSafeTelePhone("연락처(유선)", parameterMap.get("admin_tel")[0]);
		TelePhone phone = validator.getSafeTelePhone("연락처(무선)", parameterMap.get("admin_phone")[0]);
		Email email = validator.getSafeEmail("이메일 주소", parameterMap.get("admin_email")[0]);

		return new Admin(type, name, position, tel, phone, email);
	}

	public Apartment getApartment() throws InputInvalidException {

		String apartName = validator.getSafeString("아파트 명", parameterMap.get("apart_name")[0], MAX_NAME_LEGTH);
		String apartType = validator.getSafeString("아파트 구분", parameterMap.get("apart_type")[0], MAX_TYPE_LEGTH);
		String registerNum = validator.getSafeString("사업자 등록번호", parameterMap.get("apart_registerNum")[0], MAX_TYPE_LEGTH);
		String repType = validator.getSafeString("대표자 구분", parameterMap.get("apart_repType")[0], MAX_TYPE_LEGTH);
		String repName = validator.getSafeString("대표자 성명", parameterMap.get("apart_repName")[0], MAX_NAME_LEGTH);
		TelePhone tel = validator.getSafeTelePhone("아파트 연락처", parameterMap.get("apart_tel")[0]);
		TelePhone fax = validator.getSafeTelePhone("팩스", parameterMap.get("apart_fax")[0]);
		String address = validator.getSafeString("아파트 소재지", parameterMap.get("apart_address")[0], MAX_ADDRESS_LEGTH);

		return new Apartment(apartName, apartType, registerNum, repName, repType, tel, fax, address);
	}

	public FilePath getFilePath() throws InputInvalidException {

		String regisNumCardPath = validator.getSafeString("고유번호증", parameterMap.get("file_regisNumCard")[0], MAX_FILE_LEGTH);
		String baseDocPath = validator.getSafeString("투표신청 근거서류", parameterMap.get("file_baseDoc")[0], MAX_FILE_LEGTH);
		String managerCertifyPath = validator.getSafeString("관리소장 직인 및 배치신고 증명서", parameterMap.get("file_managerCertify")[0], MAX_FILE_LEGTH);
		String persAgreementPath = validator.getSafeString("개인정보수집 동의서", parameterMap.get("file_persAgreement")[0], MAX_FILE_LEGTH);
		String usageAgreementPath = validator.getSafeString("이용협약서", parameterMap.get("file_usageAgreement")[0], MAX_FILE_LEGTH);

		return new FilePath(regisNumCardPath, baseDocPath, managerCertifyPath, persAgreementPath, usageAgreementPath);
	}
}
