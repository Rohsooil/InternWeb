package com.roh.model.application;

import com.roh.forms.Email;
import com.roh.forms.TelePhone;

public class Admin implements ApplicationModel {
	private String type;
	private String name;
	private String position;
	private TelePhone tel;
	private TelePhone phone;
	private Email email;

	public Admin() {

	}

	public Admin(String type, String name, String position, TelePhone tel, TelePhone phone, Email email) {
		this.type = type;
		this.name = name;
		this.position = position;
		this.tel = tel;
		this.phone = phone;
		this.email = email;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

}
