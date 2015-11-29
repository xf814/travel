package com.trip.domain;

public class Friend {
	private int userId;
	private int friendId;
	public Friend(int userId, int friendId) {
		super();
		this.userId = userId;
		this.friendId = friendId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}
	
	
	
}
