package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Praise;





public interface PraiseDao {
       public ArrayList<Praise> query(int id) throws SQLException;
       public int delete(int userId,int circleId)throws SQLException;
	   public int insert(Praise p) throws SQLException;
}
