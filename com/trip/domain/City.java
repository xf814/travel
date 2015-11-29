package com.trip.domain;

public class City {
	private String cityName = null;
	private String cityJianjie = null;
	private String placeImage = null;
	private String cityTravelSeason = null;
	private String cityFestival = null;
	private String cityHospital = null;
	private String cityImportTel = null;
	private String cityCustom = null;
	private String cityNos = null;

	@Override
	public String toString() {
		return "City [cityName=" + cityName + ", cityJianjie=" + cityJianjie
				+ ", placeImage=" + placeImage + ", cityTravelSeason="
				+ cityTravelSeason + ", cityFestival=" + cityFestival
				+ ", cityHospital=" + cityHospital + ", cityImportTel="
				+ cityImportTel + ", cityCustom=" + cityCustom + ", cityNos="
				+ cityNos + "]";
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityJianjie() {
		return cityJianjie;
	}

	public void setCityJianjie(String cityJianjie) {
		this.cityJianjie = cityJianjie;
	}

	public String getPlaceImage() {
		return placeImage;
	}

	public void setPlaceImage(String placeImage) {
		this.placeImage = placeImage;
	}

	public String getCityTravelSeason() {
		return cityTravelSeason;
	}

	public void setCityTravelSeason(String cityTravelSeason) {
		this.cityTravelSeason = cityTravelSeason;
	}

	public String getCityFestival() {
		return cityFestival;
	}

	public void setCityFestival(String cityFestival) {
		this.cityFestival = cityFestival;
	}

	public String getCityHospital() {
		return cityHospital;
	}

	public void setCityHospital(String cityHospital) {
		this.cityHospital = cityHospital;
	}

	public String getCityImportTel() {
		return cityImportTel;
	}

	public void setCityImportTel(String cityImportTel) {
		this.cityImportTel = cityImportTel;
	}

	public String getCityCustom() {
		return cityCustom;
	}

	public void setCityCustom(String cityCustom) {
		this.cityCustom = cityCustom;
	}

	public String getCityNos() {
		return cityNos;
	}

	public void setCityNos(String cityNos) {
		this.cityNos = cityNos;
	}

	public City(String cityName, String cityJianjie, String placeImage,
			String cityTravelSeason, String cityFestival, String cityHospital,
			String cityImportTel, String cityCustom, String cityNos) {
		super();
		this.cityName = cityName;
		this.cityJianjie = cityJianjie;
		this.placeImage = placeImage;
		this.cityTravelSeason = cityTravelSeason;
		this.cityFestival = cityFestival;
		this.cityHospital = cityHospital;
		this.cityImportTel = cityImportTel;
		this.cityCustom = cityCustom;
		this.cityNos = cityNos;
	}

	public City() {
		super();
	}

}
