package com.roh.validator.data;

public class NumberValidator {

	public boolean isNumber(String data) {
		return data.matches("[0-9]+");
	}

	public boolean isSafeLength(String data, int maxLength) {
		return Integer.parseInt(data) <= maxLength;
	}
}
