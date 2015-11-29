package com.trip.domain;

public class Album{
	private int albumId;
	private String albumDate;
	private int albumUserId;
	private String albumDescribe;
	private String albumname;
	public Album(int albumId, String albumDate, int albumUserId,
			String albumDescribe, String albumname) {
		super();
		this.albumId = albumId;
		this.albumDate = albumDate;
		this.albumUserId = albumUserId;
		this.albumDescribe = albumDescribe;
		this.albumname = albumname;
	}
	public int getAlbumId() {
		return albumId;
	}
	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}
	public String getAlbumDate() {
		return albumDate;
	}
	public void setAlbumDate(String albumDate) {
		this.albumDate = albumDate;
	}
	public int getAlbumUserId() {
		return albumUserId;
	}
	public void setAlbumUserId(int albumUserId) {
		this.albumUserId = albumUserId;
	}
	public String getAlbumDescribe() {
		return albumDescribe;
	}
	public void setAlbumDescribe(String albumDescribe) {
		this.albumDescribe = albumDescribe;
	}
	public String getAlbumname() {
		return albumname;
	}
	public void setAlbumname(String albumname) {
		this.albumname = albumname;
	}
	
}