package com.trip.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.PraiseDao;
import com.trip.db.DB;
import com.trip.domain.Praise;

public class PraiseImpl implements PraiseDao{

	@Override
	public int delete(int userId,int circleId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		String sql="delete from Praise where user_id=?,circle_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, circleId);
			rs=pst.executeUpdate();
		
		}
		finally{
			DB.close(con, pst);
		}
		return rs;
	}

	@Override
	public ArrayList<Praise> query(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList<Praise> ap=new ArrayList<Praise>();
		sql="select * from Praise where circle_id=?";
		try {
		con=DB.connect();
		pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		rs=DB.getResultSet(pst);
		while(rs.next()){
			ap.add(new Praise(rs.getInt(1),rs.getDate(2),rs.getInt(3)));
		}
		}
		finally {

			DB.close(con, pst, rs);

		}
		return ap;
	}

	@Override
	public int insert(Praise p) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		Object obj[] ={p.getPraiseUserId(),p.getPraiseDate(),p.getCircleId()};
		String sql="insert into Praise(praise_user_id,praise_date,circle_id) values(?,?,?)";
		try{
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=DB.executeUpdate(pst);
			
			}
		finally {
			DB.close(con, pst);
		}
		return rs;
	}

	
	

}
