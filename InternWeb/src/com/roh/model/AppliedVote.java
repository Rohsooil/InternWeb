package com.roh.model;

public class AppliedVote {
	private int num;
	private String title;
	private String startDate;
	private String endDate;
	private String applyDate;

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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
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
			setStartDate(data);
			break;
		case 4:
			setEndDate(data);
			break;
		case 5:
			setApplyDate(data);
			break;
		default:
			break;
		}
	}

	@Override
	public String toString() {
		return "{ \"vote_num\" : \"" + num + "\" ,"
						+ "\"title\" : \"" + title + "\","
						+ " \"startDate\" : \"" + startDate + "\","
						+ " \"endDate\" : \"" + endDate + "\","
						+ " \"applyDate\" : \"" + applyDate + "\" }";
	}
}
