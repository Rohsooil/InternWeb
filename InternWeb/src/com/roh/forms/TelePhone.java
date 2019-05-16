package com.roh.forms;

public class TelePhone {
	private String areaCode;
	private String countryCode;
	private String individualCode;

	public TelePhone(String telePhone) {
		this.areaCode = telePhone.split("-")[0];
		this.countryCode = telePhone.split("-")[1];
		this.individualCode = telePhone.split("-")[2];
	}

	public String getAreaCode() {
		return areaCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getIndividualCode() {
		return individualCode;
	}

	@Override
	public String toString() {
		return areaCode + "-" + countryCode + "-" + individualCode;
	}

}
