package com.roh.validator.data;

public class StringValidator {

	public static final int MAX_TITLE_LENGTH = 30;
	public static final int MAX_NAME_LEGTH = 10;
	public static final int MAX_TYPE_LEGTH = 13;
	public static final int MAX_ADDRESS_LEGTH = 200;
	public static final int MAX_FILE_LEGTH = 250;

	public boolean isEmpty(String data) {
		return (data == null || data.trim().equals(""));
	}

	public boolean isSafeLength(String data, int maxLength) {
		return (data.length() <= maxLength);
	}

}
