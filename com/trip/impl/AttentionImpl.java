package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.AttentionDao;
import com.trip.db.DB;
import com.trip.domain.Attention;

public class AttentionImpl implements AttentionDao {
	
	public int result;
	
	 public int getResult(){
	        return result;
	    }
	
	public ArrayList<Attention> queryAttentionByUserId(int userId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Attention> ap=new ArrayList<Attention>();
		String sql="select * from Attention where follow_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1, userId);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	ap.add(new Attention(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getBoolean(4)));
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return ap;
	}
	
	public ArrayList<Attention> queryFanByUserId(int userId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Attention> ap=new ArrayList<Attention>();
		String sql="select * from Attention where followed_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1, userId);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	ap.add(new Attention(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getBoolean(4)));
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return ap;
	}
	
	
	@Override
	public int deleteAttention(int AttentionId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		sql="delete from Attention where attention_id=?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, AttentionId);
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}
		return rs;
	}
	
	@Override
	public int deleteAttention(int user1Id,int user2Id) throws SQLException{
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		sql="delete from Attention where follow_id=? and followed_id=?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, user1Id);
			pst.setInt(2, user2Id);
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}
		return rs;
	}
	
	@Override
	public int addAttention(int userId1,int userId2) throws SQLException{
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		sql="insert into Attention(follow_id,followed_id) values(?,?)";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId1);
			pst.setInt(2, userId2);
			rs = DB.executeUpdate(pst);
			result=rs;
		} finally {
			DB.close(con, pst);
		}
		return rs;
	}
	
	@Override
	public int countFollows(int userId) throws SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		int count=0;
		sql="select * from Attention where follow_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1, userId);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	count=rs.getInt(1);
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return count;
	}
	
	@Override
	public int countFans(int userId) throws SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		int count=0;
		sql="select * from Attention where followed_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1, userId);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	count=rs.getInt(1);
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return count;
	}
	
	
	@Override
	public ArrayList queryFollowedId(int userId) throws SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList al=new ArrayList();
		sql="select followed_id from Attention where follow_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1, userId);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	al.add(new Integer(rs.getInt(1)));
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return al;
	}
	
	@Override
	public String queryTag(int follow_id,int followed_id)throws SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		String tag="f";
		sql="select * from Attention where follow_id=? and followed_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1,follow_id);
		    pst.setInt(2,followed_id);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	tag="t";
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return tag;
	}


	@Override
	public ArrayList queryFollowId(int userId) throws SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList al=new ArrayList();
		sql="select follow_id from Attention where followed_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1, userId);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	al.add(new Integer(rs.getInt(1)));
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return al;
	}
	
	
	@Override
	public String queryAttentionState(int followId,int followedId) throws SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		String state="f";
		sql="select follow_id,followed_id from Attention where follow_id=? and followed_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1, followId);
		    pst.setInt(2, followedId);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	state="t";
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return state;
	}

}
