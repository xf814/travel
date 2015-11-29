package com.trip.domain;

public class Place {
	private String city;
	private String place;
	private int placeId;
	private String placeJianJie;
	private String imgPattern;
	private String placeTieShi;
	private String placeMenPiao;
	private String placeShiJian;
	private String placeJiaoTong;
	private String placeJiaGe;
	private String placePingFen;
	private String placeDiZhi;

	public Place() {
		super();
	}

	public Place(String city, String place, String placeJianJie,
			String imgPattern, String placeTieShi, String placeMenPiao,
			String placeShiJian, String placeJiaoTong, String placeJiaGe,
			String placePingFen, String placeDiZhi) {
		super();
		this.city = city;
		this.place = place;
		this.placeJianJie = placeJianJie;
		this.imgPattern = imgPattern;
		this.placeTieShi = placeTieShi;
		this.placeMenPiao = placeMenPiao;
		this.placeShiJian = placeShiJian;
		this.placeJiaoTong = placeJiaoTong;
		this.placeJiaGe = placeJiaGe;
		this.placePingFen = placePingFen;
		this.placeDiZhi = placeDiZhi;
	}

	public String toString() {
		return city + place + placeJianJie + imgPattern + placeTieShi
				+ placeMenPiao + placeShiJian + placeJiaoTong + placeJiaGe
				+ placePingFen + placeDiZhi;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getPlaceJianJie() {
		return placeJianJie;
	}

	public void setPlaceJianJie(String placeJianJie) {
		this.placeJianJie = placeJianJie;
	}

	public String getImgPattern() {
		return imgPattern;
	}

	public void setImgPattern(String imgPattern) {
		this.imgPattern = imgPattern;
	}

	public String getPlaceTieShi() {
		return placeTieShi;
	}

	public void setPlaceTieShi(String placeTieShi) {
		this.placeTieShi = placeTieShi;
	}

	public String getPlaceMenPiao() {
		return placeMenPiao;
	}

	public void setPlaceMenPiao(String placeMenPiao) {
		this.placeMenPiao = placeMenPiao;
	}

	public String getPlaceShiJian() {
		return placeShiJian;
	}

	public void setPlaceShiJian(String placeShiJian) {
		this.placeShiJian = placeShiJian;
	}

	public String getPlaceJiaoTong() {
		return placeJiaoTong;
	}

	public void setPlaceJiaoTong(String placeJiaoTong) {
		this.placeJiaoTong = placeJiaoTong;
	}

	public String getPlaceJiaGe() {
		return placeJiaGe;
	}

	public void setPlaceJiaGe(String placeJiaGe) {
		this.placeJiaGe = placeJiaGe;
	}

	public String getPlacePingFen() {
		return placePingFen;
	}

	public void setPlacePingFen(String placePingFen) {
		this.placePingFen = placePingFen;
	}

	public String getPlaceDiZhi() {
		return placeDiZhi;
	}

	public void setPlaceDiZhi(String placeDiZhi) {
		this.placeDiZhi = placeDiZhi;
	}

}