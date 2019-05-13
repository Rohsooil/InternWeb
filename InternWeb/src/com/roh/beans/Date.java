package com.roh.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Date {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	private int lastDayOfMonth;

	public Date() {
		LocalDateTime now = LocalDateTime.now();
		this.year = now.getYear();
		this.month = now.getMonthValue();
		this.day = now.getDayOfMonth();
		this.hour = now.getHour();
		this.min = now.getMinute();
		this.lastDayOfMonth = now.getMonth().length(LocalDate.now().isLeapYear());
	}

	public Date(String date) {
		String[] date_arr = date.split(" ");

		this.year = Integer.parseInt(date_arr[0].split("-")[0]);
		this.month = Integer.parseInt(date_arr[0].split("-")[1]);
		this.day = Integer.parseInt(date_arr[0].split("-")[2]);

		this.hour = Integer.parseInt(date_arr[1].split(":")[0]);
		this.min = Integer.parseInt(date_arr[1].split(":")[1]);
	}

	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getHour() {
		return hour;
	}

	public int getMin() {
		return min;
	}

	public int getLastDayOfMonth() {
		return lastDayOfMonth;
	}

	@Override
	public String toString() {
		return year + "-" + month + "-" + day + " " + hour + ":" + min;
	}

	public int compare(Date d) {
		LocalDateTime thisTime = LocalDateTime.of(year, month, day, hour, min);
		LocalDateTime comapreTime = LocalDateTime.of(d.getYear(), d.getMonth(), d.getDay(), d.getHour(), d.getMin());

		if (thisTime.isAfter(comapreTime)) {
			return 1;
		} else if (thisTime.isBefore(comapreTime)) {
			return -1;
		}
		return 0;
	}
}
