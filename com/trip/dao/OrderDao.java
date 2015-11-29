package com.trip.dao;

import java.sql.SQLException;

import com.trip.domain.Order;

public interface OrderDao {

	public int insert(Order o) throws SQLException;

}
