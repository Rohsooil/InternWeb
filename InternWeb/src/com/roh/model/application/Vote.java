package com.roh.model.application;

import com.roh.forms.Date;

public class Vote implements ApplicationModel {
	private String title;
	private String type;
	private int estimate;
	private Date startDate;
	private Date endDate;

	public Vote() {

	}

	public Vote(String title, String type, int estimate, Date startDate, Date endDate) {
		this.title = title;
		this.type = type;
		this.estimate = estimate;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = new Date(startDate);
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = new Date(endDate);
	}

	public int getEstimate() {
		return estimate;
	}

	public void setEstimate(String estimate) {
		this.estimate = Integer.parseInt(estimate);
	}

}
