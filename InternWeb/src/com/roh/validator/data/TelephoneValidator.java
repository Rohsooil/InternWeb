package com.roh.validator.data;

public class TelephoneValidator {

	public boolean isTelePhoneFormat(String data) {
		return data.matches("([0-9]{1,4})-([0-9]{1,4})-([0-9]{1,4})");
	}

}
