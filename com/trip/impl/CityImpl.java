package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.trip.dao.CityDao;
import com.trip.db.DB;
import com.trip.domain.City;

public class CityImpl implements CityDao {
	@Override
	public int insert(City c) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = -1;
		String sql = "insert into City (city_name, city_jianjie ,place_image ,city_travel_season,"
				+ "city_festival ,city_hospital ,city_import_tel ,city_custom ,city_nos)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		Object[] obj = { c.getCityName(), c.getCityJianjie(),
				c.getPlaceImage(), c.getCityTravelSeason(),
				c.getCityFestival(), c.getCityHospital(), c.getCityImportTel(),
				c.getCityCustom(), c.getCityNos() };
		try {
			System.out.println(obj.length);
			con = DB.connect();
			pst = DB.getPreparStatement(sql, con, obj);
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}
		return rs;
	}

	@Override
	public City queryByCityName(String name) throws SQLException {
		City city = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		sql = "select * from City where city_name=?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setString(1, name);
			rs = DB.getResultSet(pst);
			if (rs.next()) {
				city = new City(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getString(7), rs.getString(8),
						rs.getString(9));
			}
		} finally {
			DB.close(con, pst, rs);
		}
		return city;
	}

	@Override
	public int update(City c) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		int rs = -1;
		String sql = "update City set city_name = ?, city_jianjie = ? ,place_image =? ,city_travel_season= ? ,"
				+ "city_festival = ? ,city_hospital = ? ,city_import_tel = ? ,city_custom = ? ,city_nos= ?";
		Object[] obj = { c.getCityName(), c.getCityJianjie(),
				c.getPlaceImage(), c.getCityTravelSeason(),
				c.getCityFestival(), c.getCityHospital(), c.getCityImportTel(),
				c.getCityCustom(), c.getCityNos() };
		try {
			System.out.println(obj.length);
			con = DB.connect();
			pst = DB.getPreparStatement(sql, con, obj);
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}
		return rs;
	}
	
	@Override
	public String searchCityName(String cityName) throws SQLException{
		String resultcityName = null;
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		sql = "select city_name from City where city_name=?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setString(1, cityName);
			rs = DB.getResultSet(pst);
			if (rs.next()) {
				resultcityName=rs.getString(1);
			}
			else resultcityName="没有搜索结果";
		} finally {
			DB.close(con, pst, rs);
		}
		return resultcityName;
	
		
	}
	
	
	
	
	
	

}
