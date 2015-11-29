package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.FriendDao;
import com.trip.db.DB;
import com.trip.domain.Friend;

public class FriendImpl implements FriendDao{

	@Override
	public ArrayList<Friend> query(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList<Friend> af=new ArrayList<Friend>();
		sql="select * from Friend where friend_id=?";
		try {
		con=DB.connect();
		pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		rs=DB.getResultSet(pst);
		while(rs.next()){
			af.add(new Friend(rs.getInt(1),rs.getInt(2)));
		}
		}
		finally {

			DB.close(con, pst, rs);

		}
		return af;
	}
	@Override
	public int delete(int userId,int friendId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		sql="delete friend_id from Friend where user_id=?,friend_id=?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, friendId);
			
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}
		return rs;
	}
	@Override
	public int add(Friend f) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		Object obj[] = {f.getFriendId(),f.getUserId()};
		sql="insert into Friend (friend_id,user_id) values(?,?)";
		try {
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=DB.executeUpdate(pst);
			 } finally {
		            DB.close(con, pst);
	                  }
	           return rs;
		
	}


	@Override
	public int update(Friend f,int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		Object obj[] = {f.getFriendId(),id};
		sql="update Friend set friend_id=? where user_id=?";
		try {
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=pst.executeUpdate();	
		
	        } finally {
		            DB.close(con, pst);
	                  }
	           return rs;
		
	}
	

}
