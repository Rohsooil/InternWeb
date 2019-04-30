package com.roh.dto;

public class VoteDTO {
	private int num;
	private String title;
	private String startDay;
	private String endDay;
	private String applyDay;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getApplyDay() {
		return applyDay;
	}

	public void setApplyDay(String applyDay) {
		this.applyDay = applyDay;
	}

	public void setInstance(int index, String data) {
		switch (index) {
		case 1:
			setNum(Integer.parseInt(data));
			break;
		case 2:
			setTitle(data);
			break;
		case 3:
			setStartDay(data);
			break;
		case 4:
			setEndDay(data);
			break;
		case 5:
			setApplyDay(data);
			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "{ \"vote_num\" : \"" + num + "\" ,"
						+ "\"title\" : \"" + title + "\","
						+ " \"startDay\" : \"" + startDay + "\","
						+ " \"endDay\" : \"" + endDay + "\","
						+ " \"applyDay\" : \"" + applyDay + "\" }";
	}

}
