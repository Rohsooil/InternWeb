package com.roh.model;

public class VoteMedia implements DBModel {
	private int pc;
	private int smartPhone;
	private int sms;
	private int onSite;

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getSmartPhone() {
		return smartPhone;
	}

	public void setSmartPhone(int smartPhone) {
		this.smartPhone = smartPhone;
	}

	public int getSms() {
		return sms;
	}

	public void setSms(int sms) {
		this.sms = sms;
	}

	public int getOnSite() {
		return onSite;
	}

	public void setOnSite(int onSite) {
		this.onSite = onSite;
	}

	@Override
	public String getMember(int index) {
		String result = null;
		switch (index) {
		case 1:
			result = getPc() + "";
			break;
		case 2:
			result = getSmartPhone() + "";
			break;
		case 3:
			result = getSms() + "";
			break;
		case 4:
			result = getOnSite() + "";
			break;
		default:
			break;
		}
		return result;
	}

	public void setMember(int index, int data) {
		switch (index) {
		case 1:
			setPc(data);
			break;
		case 2:
			setSmartPhone(data);
			break;
		case 3:
			setSms(data);
			break;
		case 4:
			setOnSite(data);
			break;
		default:
			break;

		}
	}

	@Override
	public void setMember(int index, String data) {
		setMember(index, Integer.parseInt(data));
	}

}
