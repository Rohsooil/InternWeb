package com.roh.model;

public class Apartment {
	private String apartName;
	private int apartType;
	private String registerNum;
	private String repName;
	private int repType;
	private String tel;
	private String fax;
	private String address;

	public String getApartName() {
		return apartName;
	}

	public void setApartName(String apartName) {
		this.apartName = apartName;
	}

	public int getApartType() {
		return apartType;
	}

	public void setApartType(int apartType) {
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

	public int getRepType() {
		return repType;
	}

	public void setRepType(int repType) {
		this.repType = repType;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setInstance(int index, String data) {
		switch (index) {
		case 1:
			setApartName(data);
			break;
		case 2:
			setApartType(Integer.parseInt(data));
			break;
		case 3:
			setRegisterNum(data);
			break;
		case 4:
			setRepType(Integer.parseInt(data));
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

}
