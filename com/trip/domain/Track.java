package com.trip.domain;

import java.util.Date;

public class Track {
    private int trackId=0;
    private int placeId=0;
    private int userId=0;
    private Date trackDate=null;
	public Track(int trackId, int placeId, int userId, Date trackDate) {
		super();
		this.trackId = trackId;
		this.placeId = placeId;
		this.userId = userId;
		this.trackDate = trackDate;
	}
	public int getTrackId() {
		return trackId;
	}
	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}
	public int getPlaceId() {
		return placeId;
	}
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getTrackDate() {
		return trackDate;
	}
	public void setTrackDate(Date trackDate) {
		this.trackDate = trackDate;
	}
    
}
