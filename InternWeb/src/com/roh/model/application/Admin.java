package com.roh.model.application;

import com.roh.beans.Email;
import com.roh.beans.TelePhone;
import com.roh.model.ApplicationModel;

public class Admin implements ApplicationModel {
	private String type;
	private String name;
	private String rank;
	private TelePhone tel;
	private TelePhone phone;
	private Email email;

	public Admin() {

	}

	public Admin(String type, String name, String rank, String tel, String phone, String email) {
		this.type = type;
		this.name = name;
		this.rank = rank;
		this.tel = new TelePhone(tel);
		this.phone = new TelePhone(phone);
		this.email = new Email(email);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public TelePhone getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = new TelePhone(tel);
	}

	public TelePhone getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = new TelePhone(phone);
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = new Email(email);
	}

	@Override
	public void setMember(int index, String data) {
		switch (index) {
		case 1:
			setType(data);
			break;
		case 2:
			setName(data);
			break;
		case 3:
			setRank(data);
			break;
		case 4:
			setTel(data);
			break;
		case 5:
			setPhone(data);
			break;
		case 6:
			setEmail(data);
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
			member = getType();
			break;
		case 2:
			member = getName();
			break;
		case 3:
			member = getRank();
			break;
		case 4:
			member = getTel().toString();
			break;
		case 5:
			member = getPhone().toString();
			break;
		case 6:
			member = getEmail().toString();
			break;
		default:
			break;
		}

		return member;
	}

}
