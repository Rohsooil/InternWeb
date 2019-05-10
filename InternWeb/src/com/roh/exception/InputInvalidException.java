package com.roh.exception;

public class InputInvalidException extends Exception {
	private static final long serialVersionUID = 1L;
	private final String message = " 입력값이 올바르지 않습니다";
	private String name;

	public InputInvalidException(String name) {
		this.name = name;
	}

	@Override
	public String getMessage() {
		return name + message;
	}

}
