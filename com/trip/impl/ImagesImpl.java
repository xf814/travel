package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.ImagesDao;
import com.trip.db.DB;


public class ImagesImpl implements ImagesDao{
	@Override
	public ArrayList<String> query(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<String> ac=new ArrayList<String>();
		String sql="select * from Images where circle_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			rs=DB.getResultSet(pst);
			while(rs.next()){
				ac.add(rs.getString(2));
			}
			
		}finally{
			DB.close(con, pst);
		}
		return ac;
	}
}
