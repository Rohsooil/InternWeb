package com.roh.model.application;

import com.roh.forms.TelePhone;

public class Apartment implements ApplicationModel {
	private String name;
	private String type;
	private String registerNum;
	private String repType;
	private String repName;
	private TelePhone tel;
	private TelePhone fax;
	private String address;

	public Apartment() {

	}

	public Apartment(String name, String type, String registerNum, String repName, String repType, TelePhone tel, TelePhone fax, String address) {
		this.name = name;
		this.type = type;
		this.registerNum = registerNum;
		this.repName = repName;
		this.repType = repType;
		this.tel = tel;
		this.fax = fax;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}
