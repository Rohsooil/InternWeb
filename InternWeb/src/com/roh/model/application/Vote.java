package com.roh.model.application;

import com.roh.beans.Date;
import com.roh.model.ApplicationModel;

public class Vote implements ApplicationModel {
	private String title;
	private String type;
	private int estimate;
	private Date startDay;
	private Date endDay;

	public Vote() {
	
	}
	
	public Vote(String title, String type, int estimate, Date startDay, Date endDay) {
		this.title = title;
		this.type = type;
		this.estimate = estimate;
		this.startDay = startDay;
		this.endDay = endDay;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartDay() {
		return startDay;
	}

	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}

	public Date getEndDay() {
		return endDay;
	}

	public void setEndDay(Date endDay) {
		this.endDay = endDay;
	}

	public int getEstimate() {
		return estimate;
	}

	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}

	@Override
	public void setMember(int index, String data) {
		switch (index) {
		case 1:
			setTitle(data);
			break;
		case 2:
			setType(data);
			break;
		case 3:
			setEstimate(Integer.parseInt(data));
			break;
		case 4:
			setStartDay(new Date(data));
			break;
		case 5:
			setEndDay(new Date(data));
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
			member = getTitle();
			break;
		case 2:
			member = getType();
			break;
		case 3:
			member = getEstimate() + "";
			break;
		case 4:
			member = getStartDay().toString();
			break;
		case 5:
			member = getEndDay().toString();
			break;
		default:
			break;
		}

		return member;
	}
}
