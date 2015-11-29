package com.trip.domain;

import java.util.Date;

public class Order {
	private int orderId =0;
	private int orderMoney =0;
	private String orderHotel=null;
	private Date orderBookdDay =null;
	private int orderDays =0;
	private int userId =0;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getOrderHotel() {
		return orderHotel;
	}
	public void setOrderHotel(String orderHotel) {
		this.orderHotel = orderHotel;
	}
	public Date getOrderBookdDay() {
		return orderBookdDay;
	}
	public void setOrderBookdDay(Date orderBookdDay) {
		this.orderBookdDay = orderBookdDay;
	}
	public int getOrderDays() {
		return orderDays;
	}
	public void setOrderDays(int orderDays) {
		this.orderDays = orderDays;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Order(int orderId, int orderMoney, String orderHotel,
			Date orderBookdDay, int orderDays, int userId) {
		super();
		this.orderId = orderId;
		this.orderMoney = orderMoney;
		this.orderHotel = orderHotel;
		this.orderBookdDay = orderBookdDay;
		this.orderDays = orderDays;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderMoney=" + orderMoney
				+ ", orderHotel=" + orderHotel + ", orderBookdDay="
				+ orderBookdDay + ", orderDays=" + orderDays + ", userId="
				+ userId + "]";
	}
	public Order() {
		super();
	}
	
}
