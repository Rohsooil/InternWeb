package com.roh.forms;

public class Email {
	private String identifier;
	private String domain;

	public Email(String Email) {
		this.identifier = Email.split("@")[0];
		this.domain = Email.split("@")[1];
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getDomain() {
		return domain;
	}

	@Override
	public String toString() {
		return identifier + "@" + domain;
	}
}
