package com.roh.model.application;

public class VoteMedia implements ApplicationModel {
	private int pc;
	private int smartPhone;
	private int sms;
	private int onSite;

	public VoteMedia() {

	}

	public int getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = Integer.parseInt(pc);
	}

	public int getSmartPhone() {
		return smartPhone;
	}

	public void setSmartPhone(String smartPhone) {
		this.smartPhone = Integer.parseInt(smartPhone);
	}

	public int getSms() {
		return sms;
	}

	public void setSms(String sms) {
		this.sms = Integer.parseInt(sms);
	}

	public int getOnSite() {
		return onSite;
	}

	public void setOnSite(String onSite) {
		this.onSite = Integer.parseInt(onSite);
	}

}
