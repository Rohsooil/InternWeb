package com.roh.validator;

import com.roh.exception.InputInvalidException;
import com.roh.forms.Date;
import com.roh.forms.Email;
import com.roh.forms.TelePhone;
import com.roh.validator.data.DateValidator;
import com.roh.validator.data.NumberValidator;
import com.roh.validator.data.StringValidator;
import com.roh.validator.data.TelephoneValidator;

public class ModelValidator {
	private StringValidator stringValidator;
	private NumberValidator numberValidator;
	private DateValidator dateValidator;
	private TelephoneValidator telephoneValidator;
	// private EmailValidator emailValidator;

	public ModelValidator() {
		this.stringValidator = new StringValidator();
		this.numberValidator = new NumberValidator();
		this.dateValidator = new DateValidator();
		this.telephoneValidator = new TelephoneValidator();
		// this.emailValidator = new EmailValidator();
	}

	public String getSafeString(String label, String data, int maxLength) throws InputInvalidException {

		if (stringValidator.isEmpty(data) || !stringValidator.isSafeLength(data, maxLength)) {
			throw new InputInvalidException(label);
		}

		return data;
	}

	public int getSafeInt(String label, String data) throws InputInvalidException {

		if (stringValidator.isEmpty(data) || !numberValidator.isNumber(data)) {
			throw new InputInvalidException(label);
		}

		return Integer.parseInt(data);
	}

	public Date getSafeDate(String label, String data) throws InputInvalidException {

		if (stringValidator.isEmpty(data) || !dateValidator.isDateFormat(data)) {
			throw new InputInvalidException(label);
		}

		return new Date(data);
	}

	public TelePhone getSafeTelePhone(String label, String data) throws InputInvalidException {

		if (stringValidator.isEmpty(data) || !telephoneValidator.isTelePhoneFormat(data)) {
			throw new InputInvalidException(label);
		}

		return new TelePhone(data);
	}

	public Email getSafeEmail(String label, String data) throws InputInvalidException {

		if (stringValidator.isEmpty(data)) {
			throw new InputInvalidException(label);
		}

		return new Email(data);
	}

	public String[] getSafeMedia(String label, String[] data) throws InputInvalidException {
		if (data == null || data.length == 0) {
			throw new InputInvalidException(label);
		}
		return data;
	}

}
