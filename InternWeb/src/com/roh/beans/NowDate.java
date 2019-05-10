package com.roh.beans;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NowDate {
	private int year;
	private int month;
	private int day;
	private int hour;
	private int min;
	private int lastDayOfMonth;

	public NowDate() {
		LocalDateTime now = LocalDateTime.now();
		this.year = now.getYear();
		this.month = now.getMonthValue();
		this.day = now.getDayOfMonth();
		this.hour = now.getHour();
		this.min = now.getMinute();
		this.lastDayOfMonth = now.getMonth().length(LocalDate.now().isLeapYear());
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

	public int getLastDayOfMonth() {
		return lastDayOfMonth;
	}

}
