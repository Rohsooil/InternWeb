package com.roh.forms;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		this.lastDayOfMonth = now.getMonth().length(now.toLocalDate().isLeapYear());
	}

	public Date(String date) {
		LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		this.year = dateTime.getYear();
		this.month = dateTime.getMonthValue();
		this.day = dateTime.getDayOfMonth();
		this.hour = dateTime.getHour();
		this.min = dateTime.getMinute();
		this.lastDayOfMonth = dateTime.getMonth().length(dateTime.toLocalDate().isLeapYear());

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
		return year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day) + " " + String.format("%02d", hour) + ":"
				+ String.format("%02d", min) + ":00";
	}

	public LocalDateTime toLocalDateTime() {
		return LocalDateTime.parse(toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

}
