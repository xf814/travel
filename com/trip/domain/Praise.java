package com.trip.domain;

import java.util.Date;

public class Praise {
     private int praiseUserId=0;
     private Date praiseDate=null;
     private int circleId=0;
	public Praise(int praiseUserId, Date praiseDate, int circleId) {
		super();
		this.praiseUserId = praiseUserId;
		this.praiseDate = praiseDate;
		this.circleId = circleId;
	}
	public int getPraiseUserId() {
		return praiseUserId;
	}
	public void setPraiseUserId(int praiseUserId) {
		this.praiseUserId = praiseUserId;
	}
	public Date getPraiseDate() {
		return praiseDate;
	}
	public void setPraiseDate(Date praiseDate) {
		this.praiseDate = praiseDate;
	}
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
}