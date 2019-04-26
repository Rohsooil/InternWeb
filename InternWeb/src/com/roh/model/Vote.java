package com.roh.model;

public class Vote {
	private String title;
	private int type;
	private int estimate;
	private String startDay;
	private String endDay;
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

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getEndDay() {
		return endDay;
	}

	public void setEndDay(String endDay) {
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

	// https://yoonka.tistory.com/450
}
