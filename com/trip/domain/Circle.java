package com.trip.domain;

import java.util.Date;

public class Circle {

	private int circleId = 0;
	private int userId = 0;
	private String circleContent = null;
	private String circleDate = null;
	private String circleTime = null;
	private int praiseCount = 0;

	public Circle() {
		super();
	}

	public Circle(int circleId, int userId, String circleContent,
			String circleDate, String circleTime, int praiseCount) {
		super();
		this.circleId = circleId;
		this.userId = userId;
		this.circleContent = circleContent;
		this.circleDate = circleDate;
		this.circleTime = circleTime;
		this.praiseCount = praiseCount;
	}

	public int getCircleId() {
		return circleId;
	}

	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCircleContent() {
		return circleContent;
	}

	public void setCircleContent(String circleContent) {
		this.circleContent = circleContent;
	}

	public String getCircleDate() {
		return circleDate;
	}

	public void setCircleDate(String circleDate) {
		this.circleDate = circleDate;
	}

	public String getCircleTime() {
		return circleTime;
	}

	public void setCircleTime(String circleTime) {
		this.circleTime = circleTime;
	}

	public int getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(int praiseCount) {
		this.praiseCount = praiseCount;
	}

	@Override
	public String toString() {
		return circleId + "aa" + userId + "aa" + circleContent + "aa"
				+ circleDate + "aa" + circleTime + "aa" + praiseCount + "aa";
	}

}