package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.CircleDao;
import com.trip.db.DB;
import com.trip.domain.Circle;
import com.trip.domain.Comment;


public class CircleImpl implements CircleDao{
	
	@Override
	public ArrayList<Circle> query(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Circle> ac=new ArrayList<Circle>();
		String sql="select * from Circle where circle_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=DB.getResultSet(pst);
			while(rs.next()){
			   ac.add(new Circle(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
			}
		}
		finally{
			DB.close(con, pst);
		}
		
		return ac;
	}
	@Override
	public ArrayList<Circle> queryByUserId(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Circle> ac=new ArrayList<Circle>();
		String sql="select * from Circle where user_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=DB.getResultSet(pst);
			while(rs.next()){
			   ac.add(new Circle(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
			}
		}
		finally{
			DB.close(con, pst);
		}
		
		return ac;
	}
	
	@Override
	public ArrayList<Circle> query() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Circle> ac=new ArrayList<Circle>();
		String sql="select * from Circle ";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			rs=DB.getResultSet(pst);
			while(rs.next()){
				ac.add(new Circle(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
			}
			
		}finally{
			DB.close(con, pst);
		}
		return ac;
	}
	@Override
	public int update(Circle c,int userId, int circleId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		Object obj[] = {c.getCircleContent(),circleId,userId};
		sql="update Circle set circle_content=? where circle_id=? and user_id=?";
		try {
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=pst.executeUpdate();	
		
	        } finally {
		            DB.close(con, pst);
	                  }
	           return rs;
		
	}
	

	@Override
	public void insertPraiseCount(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		int count =-1;
		String sql1="select praise_count from Circle where circle_id=?";
		String sql2="update Circle set praise_count=? where circle_id=?";
		con=DB.connect();
	    try{
	    
	    	pst=con.prepareStatement(sql1);
	    	pst.setInt(1, id);
	    	rs=DB.getResultSet(pst);
	    	if(rs.next()){
	    		count=rs.getInt(1);
	    	}
	    }
	    finally {
	    	DB.close(con, pst,rs);
	    }
	    if(count!=-1){
	    	count++;
	    	try{
	    	pst=con.prepareStatement(sql2);
	    	pst.setInt(1, count);
	    	pst.setInt(2, id);
	    	DB.executeUpdate(pst);
	    	}
	    	finally {
				DB.close(con, pst);
			}
	    }
		
	}
	@Override
	public int insert(Circle c) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		String sql="insert into Circle(user_id,circle_content,circle_date,circle_time,praise_count) values(?,?,?,?,?)";
		Object obj[]={c.getUserId(),c.getCircleContent(),c.getCircleDate(),c.getCircleTime(),c.getPraiseCount()};
	    try{
	    	con=DB.connect();
	    	pst=DB.getPreparStatement(sql, con, obj);
	    	rs=DB.executeUpdate(pst);
	    	
	    }
	    finally{
	    	DB.close(con, pst);
	    }
		return rs;
	}
	@Override
	public int deleteCircle(int circleId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		sql="delete from Circle where circle_id=?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, circleId);
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}
		return rs;
	}
	
	@Override
	public void findIdInsertImages(String time,String imagePath) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql1 = null;
		String sql2 = null;
		int circleId = -1;
		sql1 = "select circle_id from Circle where circle_time = ?";
		sql2 = "insert into Images(circle_id,image_path)  values(?,?)";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql1);
			pst.setString(1, time);
			rs = DB.getResultSet(pst);
			if (rs.next())
				circleId = rs.getInt(1);
		} finally {
			DB.close(con, pst,rs);
		}
		
		if(circleId!=-1){
			try {
			con=DB.connect();
			pst=con.prepareStatement(sql2);
			pst.setInt(1, circleId);
			pst.setString(2, imagePath);
			DB.executeUpdate(pst);
			}
			finally {
				DB.close(con, pst);
			}
			
		}
	}
@Override
	public int queryUserId(int circleId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		int userId=0;
		String sql="select user_id from Circle where circle_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setInt(1, circleId);
			rs=DB.getResultSet(pst);
			
			if(rs.next()){
			     userId=rs.getInt(1);	
			}
		}finally{
			DB.close(con, pst);
		}
		return userId;
	}
     
}
