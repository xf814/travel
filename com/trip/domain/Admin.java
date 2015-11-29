package com.trip.domain;

public class Admin {
	private int adminId;
	private String adminPassword;
	private String adminEmail;
	private String adminNickname;
	private String adminSex;
	private String adminRealname;
	private String adminTele;

	public Admin(int adminId, String adminPassword, String adminEmail,
			String adminNickname, String adminSex, String adminRealname,
			String adminTele) {
		super();
		this.adminId = adminId;
		this.adminPassword = adminPassword;
		this.adminEmail = adminEmail;
		this.adminNickname = adminNickname;
		this.adminSex = adminSex;
		this.adminRealname = adminRealname;
		this.adminTele = adminTele;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminNickname() {
		return adminNickname;
	}

	public void setAdminNickname(String adminNickname) {
		this.adminNickname = adminNickname;
	}

	public String getAdminSex() {
		return adminSex;
	}

	public void setAdminSex(String adminSex) {
		this.adminSex = adminSex;
	}

	public String getAdminRealname() {
		return adminRealname;
	}

	public void setAdminRealname(String adminRealname) {
		this.adminRealname = adminRealname;
	}

	public String getAdminTele() {
		return adminTele;
	}

	public void setAdminTele(String adminTele) {
		this.adminTele = adminTele;
	}
}