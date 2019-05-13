package com.roh.model.application;

import com.roh.beans.TelePhone;
import com.roh.model.ApplicationModel;

public class Apartment implements ApplicationModel {
	private String apartName;
	private String apartType;
	private String registerNum;
	private String repName;
	private String repType;
	private TelePhone tel;
	private TelePhone fax;
	private String address;

	public Apartment() {

	}

	public Apartment(String apartName, String apartType, String registerNum, String repName, String repType, String tel, String fax, String address) {
		this.apartName = apartName;
		this.apartType = apartType;
		this.registerNum = registerNum;
		this.repName = repName;
		this.repType = repType;
		this.tel = new TelePhone(tel);
		this.fax = new TelePhone(fax);
		this.address = address;
	}

	public String getApartName() {
		return apartName;
	}

	public void setApartName(String apartName) {
		this.apartName = apartName;
	}

	public String getApartType() {
		return apartType;
	}

	public void setApartType(String apartType) {
		this.apartType = apartType;
	}

	public String getRegisterNum() {
		return registerNum;
	}

	public void setRegisterNum(String registerNum) {
		this.registerNum = registerNum;
	}

	public String getRepName() {
		return repName;
	}

	public void setRepName(String repName) {
		this.repName = repName;
	}

	public String getRepType() {
		return repType;
	}

	public void setRepType(String repType) {
		this.repType = repType;
	}

	public TelePhone getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = new TelePhone(tel);
	}

	public TelePhone getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = new TelePhone(fax);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public void setMember(int index, String data) {
		switch (index) {
		case 1:
			setApartName(data);
			break;
		case 2:
			setApartType(data);
			break;
		case 3:
			setRegisterNum(data);
			break;
		case 4:
			setRepType(data);
			break;
		case 5:
			setRepName(data);
			break;
		case 6:
			setTel(data);
			break;
		case 7:
			setFax(data);
			break;
		case 8:
			setAddress(data);
			break;
		default:
			break;
		}
	}

	@Override
	public String getMember(int index) {
		String member = null;

		switch (index) {
		case 1:
			member = getApartName();
			break;
		case 2:
			member = getApartType();
			break;
		case 3:
			member = getRegisterNum();
			break;
		case 4:
			member = getRepType();
			break;
		case 5:
			member = getRepName();
			break;
		case 6:
			member = getTel().toString();
			break;
		case 7:
			member = getFax().toString();
			break;
		case 8:
			member = getAddress();
			break;
		default:
			break;
		}

		return member;
	}

}
