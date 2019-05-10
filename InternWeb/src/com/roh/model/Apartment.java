package com.roh.model;

public class Apartment implements DBModel {
	private String apartName;
	private int apartType;
	private String registerNum;
	private String repName;
	private int repType;
	private String tel;
	private String fax;
	private String address;

	public Apartment() {

	}

	public Apartment(String apartName, int apartType, String registerNum, String repName, int repType, String tel, String fax, String address) {
		this.apartName = apartName;
		this.apartType = apartType;
		this.registerNum = registerNum;
		this.repName = repName;
		this.repType = repType;
		this.tel = tel;
		this.fax = fax;
		this.address = address;
	}

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

	@Override
	public void setMember(int index, String data) {
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

	@Override
	public String getMember(int index) {
		String member = null;

		switch (index) {
		case 1:
			member = getApartName();
			break;
		case 2:
			member = getApartType() + "";
			break;
		case 3:
			member = getRegisterNum();
			break;
		case 4:
			member = getRepType() + "";
			break;
		case 5:
			member = getRepName();
			break;
		case 6:
			member = getTel();
			break;
		case 7:
			member = getFax();
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
