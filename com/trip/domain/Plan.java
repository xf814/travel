package com.trip.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Plan {
	private int planId = 0;
	private String authorName = null;
	private Date planTime = null;
	private String planPlace = null;
	private String planPlaceTime = null;
	private Date planCreateTime = null;
	private String planPlaceAdd = null;
	private String planPlaceImg = null;
	private String city = null;

	public Plan() {
		super();
	}

	public Plan(String authorName, Date planTime, String planPlace,
			String planPlaceTime, Date planCreateTime, String planPlaceAdd,
			String planPlaceImg, String city, int planId) {
		super();
		this.planId = planId;
		this.authorName = authorName;
		this.planTime = planTime;
		this.planPlace = planPlace;
		this.planPlaceTime = planPlaceTime;
		this.planCreateTime = planCreateTime;
		this.planPlaceAdd = planPlaceAdd;
		this.planPlaceImg = planPlaceImg;
		this.city = city;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getPlanTime() {
		return planTime;
	}

	public void setPlanTime(Date planTime) {
		this.planTime = planTime;
	}

	public String getPlanPlace() {
		return planPlace;
	}

	public void setPlanPlace(String planPlace) {
		this.planPlace = planPlace;
	}

	public String getPlanPlaceTime() {
		return planPlaceTime;
	}

	public void setPlanPlaceTime(String planPlaceTime) {
		this.planPlaceTime = planPlaceTime;
	}

	public Date getPlanCreateTime() {
		return planCreateTime;
	}

	public void setPlanCreateTime(Date planCreateTime) {
		this.planCreateTime = planCreateTime;
	}

	public String getPlanPlaceAdd() {
		return planPlaceAdd;
	}

	public void setPlanPlaceAdd(String planPlaceAdd) {
		this.planPlaceAdd = planPlaceAdd;
	}

	public String getPlanPlaceImg() {
		return planPlaceImg;
	}

	public void setPlanPlaceImg(String planPlaceImg) {
		this.planPlaceImg = planPlaceImg;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyƒÍMM‘¬dd»’ hh:mm:ss");
		return planTime + "qwert" + planPlace + "qwert" + planPlaceTime
				+ "qwert" + sdf2.format(planCreateTime) + "qwert"
				+ planPlaceAdd + "qwert" + planPlaceImg + "qwert" + city
				+ "qwert" + planId;
	}

}
