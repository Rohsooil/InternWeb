package com.roh.validator.data;

public class StringValidator {

	public boolean isEmpty(String data) {
		return (data == null || data.trim().equals(""));
	}

	public boolean isSafeLength(String data, int maxLength) {
		return (data.length() <= maxLength);
	}

}
