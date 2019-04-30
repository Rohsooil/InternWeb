package com.roh.model;

public class Admin {
	private int type;
	private String name;
	private String rank;
	private String tel;
	private String phone;
	private String email;

	public int getType() {
		return type;
	}

	public void setType(int type) {
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setInstance(int index, String data) {
		switch (index) {
		case 1:
			setType(Integer.parseInt(data));
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

}
