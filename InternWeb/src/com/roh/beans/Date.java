package com.roh.beans;

public class Date {
	private String year;
	private String month;
	private String day;
	private String hour;
	private String minute;

	public Date(String date) {
		String[] date_arr = date.split(" ");

		setYear(date_arr[0].split("-")[0]);
		setMonth(date_arr[0].split("-")[1]);
		setDay(date_arr[0].split("-")[2]);

		setHour(date_arr[1].split(":")[0]);
		setMinute(date_arr[1].split(":")[1]);
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public String getMinute() {
		return minute;
	}

	public void setMinute(String minute) {
		this.minute = minute;
	}

	@Override
	public String toString() {
		return year + "-" + month + "-" + day + " " + hour + ":" + minute;
	}
}
