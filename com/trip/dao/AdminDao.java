package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Admin;


public interface AdminDao {
	public ArrayList<Admin> query(int id) throws SQLException; 
    public int update(Admin u,int id) throws SQLException;
    public int insert(Admin admin) throws SQLException;
}
