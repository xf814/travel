package com.trip.domain;


public class Travel {
	private long id;          //��־id
	private String date;      //�μ��ϴ�����
	private String content;    //�μ�����
	private String imagepath;  //ͼƬ��ַ
	private String time;       //�ϴ�ʱ��
	private String address;    //�ϴ���ַ
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
