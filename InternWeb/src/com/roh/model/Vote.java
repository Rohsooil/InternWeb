package com.roh.model;

import com.roh.beans.Date;

public class Vote {
	private String title;
	private int type;
	private int estimate;
	private Date startDay;
	private Date endDay;
	private String[] media;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
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

	public String[] getMedia() {
		return media;
	}

	public void setMedia(String[] media) {
		this.media = media;
	}

	public int getEstimate() {
		return estimate;
	}

	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}

	public void setInstance(int index, String data) {
		switch (index) {
		case 1:
			setTitle(data);
			break;
		case 2:
			setType(Integer.parseInt(data));
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
}
