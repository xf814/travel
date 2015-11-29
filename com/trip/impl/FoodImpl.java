package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.FoodDao;
import com.trip.db.DB;
import com.trip.domain.Food;


public class FoodImpl implements FoodDao {

	@Override
	public ArrayList<Food> queryByName(String name) {
		// TODO 自动生成的方法存根
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Food> af=null;
		String sql="select * from Food where city_name=?";
		
		con=DB.connect();
		try {
			pst=con.prepareStatement(sql);
			pst.setString(1, name);
			rs=DB.getResultSet(pst);
			af=new ArrayList<Food>();
			while(rs.next()){
				af.add(new Food(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return af;
	}
	

}
