package com.trip.dao;

import java.sql.SQLException;

import com.trip.domain.City;

public interface CityDao {

	public int update(City c) throws SQLException;

	public City queryByCityName(String name) throws SQLException;

	public int insert(City c) throws SQLException;
	
	public String searchCityName(String cityName) throws SQLException;
    
} 
