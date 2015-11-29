package com.trip.domain;

import java.util.Date;

public class User {

	private int userId;
	private String userPassword;
	private String userEmail;
	private String userNickname;
	private String userSex;
	private Date userRegisterdate;
	private String userRealname;
	private String userTele;
	private String userPhoto;
	private String userBirthday;
	private String userIntro;
	private String userLocation;

	public User() {

	}

	@Override
	public String toString() {
		return userNickname + "," + userPassword;
	}

	public String toString2() {
		return userNickname + "," + userRealname + "," + userSex + ","
				+ userBirthday + "," + userTele + "," + userEmail + ","
				+ userIntro + "," + userLocation + "," + userRegisterdate;
	}

	public String toString3() {
		return userId + "," + userNickname + "," + userIntro;
	}

	public User(String userNickname, String userRealname, String userSex,
			String userBirthday, String userTele, String userEmail,
			String userIntro, String userLocation, Date userRegisterdate) {
		super();
		this.userNickname = userNickname;
		this.userRealname = userRealname;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userTele = userTele;
		this.userEmail = userEmail;
		this.userIntro = userIntro;
		this.userLocation = userLocation;
		this.userRegisterdate = userRegisterdate;
	}

	public User(String userPassword, String userEmail, String userNickname,
			Date userRegisterdate) {
		super();
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userNickname = userNickname;
		this.userRegisterdate = userRegisterdate;
	}

	public User(int userId, String userPassword, String userEmail,
			String userNickname, String userSex, Date userRegisterdate,
			String userRealname, String userTele) {
		this.userId = userId;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userNickname = userNickname;
		this.userSex = userSex;
		this.userRegisterdate = userRegisterdate;
		this.userRealname = userRealname;
		this.userTele = userTele;

	}

	public User(int userId, String userEmail, String userNickname,
			String userSex, Date userRegisterdate, String userRealname,
			String userTele, String userPhoto, String userIntro,
			String userBirthday, String userLocation) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userNickname = userNickname;
		this.userSex = userSex;
		this.userRegisterdate = userRegisterdate;
		this.userRealname = userRealname;
		this.userTele = userTele;
		this.userPhoto = userPhoto;
		this.userIntro = userIntro;
		this.userLocation = userLocation;
		this.userBirthday = userBirthday;

	}

	public User(int userId, String userNickname, String userIntro) {
		super();
		this.userId = userId;
		this.userNickname = userNickname;
		this.userIntro = userIntro;
	}

	public User(String userNickname, String userRealname, String userSex,
			String userBirthday, String userTele, String userEmail,
			String userIntro, String userLocation) {
		super();
		this.userNickname = userNickname;
		this.userRealname = userRealname;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userTele = userTele;
		this.userEmail = userEmail;
		this.userIntro = userIntro;
		this.userLocation = userLocation;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserNickname() {
		return userNickname;
	}

	public void setUserNickname(String userNickname) {
		this.userNickname = userNickname;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Date getUserRegisterdate() {
		return userRegisterdate;
	}

	public void setUserRegisterdate(Date userRegisterdate) {
		this.userRegisterdate = userRegisterdate;
	}

	public String getUserRealname() {
		return userRealname;
	}

	public void setUserRealname(String userRealname) {
		this.userRealname = userRealname;
	}

	public String getUserTele() {
		return userTele;
	}

	public void setUserTele(String userTele) {
		this.userTele = userTele;
	}

	public String getUserPhoto() {
		return userPhoto;
	}

	public void setUserPhoto(String userPhoto) {
		this.userPhoto = userPhoto;
	}

}
