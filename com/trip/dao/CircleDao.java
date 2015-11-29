package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Circle;


public interface CircleDao {
	
    public ArrayList<Circle> query(int id) throws SQLException;
    public int update(Circle c,int userId, int circleId) throws SQLException;
    public void insertPraiseCount(int id) throws SQLException;
    public int insert(Circle c) throws SQLException;
    public int deleteCircle(int circleId) throws SQLException;
	public ArrayList<Circle> query() throws SQLException;
	public void findIdInsertImages(String time, String imagePath) throws SQLException;
	public int queryUserId(int circleId) throws SQLException;
	public ArrayList<Circle> queryByUserId(int id) throws SQLException;
//	public int countCircle(int circleId) throws SQLException;
}
