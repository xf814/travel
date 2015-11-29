package com.trip.domain;

public class Food {
      private String cityName;
      private String restName;
      private String restImg;
      private String restAddr;
      private String restTel;
      private String restPingfen;
      private String restPrice;
	public Food() {
		super();
	}
	public Food(String cityName, String restName, String restImg,
			String restAddr, String restTel, String restPingfen,
			String restPrice) {
		super();
		this.cityName = cityName;
		this.restName = restName;
		this.restImg = restImg;
		this.restAddr = restAddr;
		this.restTel = restTel;
		this.restPingfen = restPingfen;
		this.restPrice = restPrice;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public String getRestImg() {
		return restImg;
	}
	public void setRestImg(String restImg) {
		this.restImg = restImg;
	}
	public String getRestAddr() {
		return restAddr;
	}
	public void setRestAddr(String restAddr) {
		this.restAddr = restAddr;
	}
	public String getRestTel() {
		return restTel;
	}
	public void setRestTel(String restTel) {
		this.restTel = restTel;
	}
	public String getRestPingfen() {
		return restPingfen;
	}
	public void setRestPingfen(String restPingfen) {
		this.restPingfen = restPingfen;
	}
	public String getRestPrice() {
		return restPrice;
	}
	public void setRestPrice(String restPrice) {
		this.restPrice = restPrice;
	}
      
}
