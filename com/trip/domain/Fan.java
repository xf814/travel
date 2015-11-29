package com.trip.domain;

public class Fan {
	private int fanId;
	private int user1_id;
	private int user2_id;
	
	public Fan(int fanId,int user1_id,int user2_id){
		this.fanId=fanId;
		this.user1_id=user1_id;
		this.user2_id=user2_id;
	}
	public int getfanId() {
		return fanId;
	}
	public void setfanId(int fanId) {
		this.fanId = fanId;
	}
	public int getuser1_id() {
		return user1_id;
	}
	public void setuser1_id(int user1_id) {
		this.user1_id = user1_id;
	}
	public int getuser2_id() {
		return user2_id;
	}
	public void setuser2_id(int user2_id) {
		this.user2_id = user2_id;
	}
	
	@Override
	public String toString() {
		return  fanId+"qwert" +user1_id + "qwert" + user2_id;
	}
}
