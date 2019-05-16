package com.roh.exception;

public class DateInvalidException extends Exception {
	private static final long serialVersionUID = 1L;
	private String message;

	public DateInvalidException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
