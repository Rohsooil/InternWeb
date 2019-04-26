package com.roh.beans;

import java.time.LocalDate;
import java.util.Calendar;

public class NowDate {
	private int year;
	private int month;
	private int day;
	private int lastDayOfMonth;

	public NowDate() {
		LocalDate now = LocalDate.now();
		this.year = now.getYear();
		this.month = now.getMonthValue();
		this.day = now.getDayOfMonth();
		this.lastDayOfMonth = Calendar.getInstance().getActualMaximum(Calendar.DATE);
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
