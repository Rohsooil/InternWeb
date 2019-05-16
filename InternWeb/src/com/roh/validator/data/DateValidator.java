package com.roh.validator.data;

import java.time.LocalDateTime;

import com.roh.forms.Date;

public class DateValidator {

	public boolean isDateFormat(String data) {
		return data.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):([0-9]{2})");
	}

	public boolean isAfter(Date start, Date end) {
		return end.toLocalDateTime().isAfter(start.toLocalDateTime());
	}

	public boolean isRigthDate(Date start, Date end) {
		LocalDateTime rightDate = start.toLocalDateTime().plusDays(3);

		return rightDate.isAfter(end.toLocalDateTime());
	}

}
