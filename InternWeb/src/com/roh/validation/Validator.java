package com.roh.validation;

import com.roh.beans.Date;
import com.roh.exception.InputInvalidException;

public class Validator {
//	private final String[] paramName = { "vote_title", "vote_type", "vote_estimate", "voteStartDate", "voteEndDate",
//			"vote_media", "admin_type", "admin_name", "admin_rank", "admin_tel", "admin_phone", "admin_email",
//			"apart_name", "apart_type", "register_num", "rep_type", "rep_name", "apart_tel", "apart_fax",
//			"apart_address", "regisNumCardPath", "baseDocPath", "managerCertifyPath", "persAgreementPath",
//			"usageAgreementPath" };

	public String getSafeString(String name, String value) throws InputInvalidException {
		if (value == null || value.equals("")) {
			throw new InputInvalidException(name);
		}
		return value;
	}

	public int getSafeInt(String name, String value) throws InputInvalidException {
		if (value == null || value.equals("") || !value.matches("[0-9]+")) {
			throw new InputInvalidException(name);
		}
		return Integer.parseInt(value);
	}

	public Date getSafeDate(String name, String value) throws InputInvalidException {
		if (value == null || value.equals("")) {
			throw new InputInvalidException(name);
		}
		return new Date(value);
	}

	public String[] getSafeMedia(String name, String[] value) throws InputInvalidException {
		if (value == null || value.length == 0) {
			throw new InputInvalidException(name);
		}
		return value;
	}
}
