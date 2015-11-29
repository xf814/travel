package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.trip.dao.CommentDao;
import com.trip.db.DB;
import com.trip.domain.Comment;



public class CommentImpl implements CommentDao{

	@Override
	public ArrayList<Comment> query(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Comment> ac=new ArrayList<Comment>();
		String sql="select * from Comment where circle_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			rs=DB.getResultSet(pst);
			while(rs.next()){
				ac.add(new Comment(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			
		}finally{
			DB.close(con, pst);
		}
		return ac;
	}
@Override
	public ArrayList<Comment> query() throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Comment> ac=new ArrayList<Comment>();
		String sql="select * from Comment ";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			rs=DB.getResultSet(pst);
			while(rs.next()){
				ac.add(new Comment(rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			
		}finally{
			DB.close(con, pst);
		}
		return ac;
	}
	
	
	@Override
	public int delete(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		String sql="delete * from Comment where circle_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=DB.executeUpdate(pst);
			
		}
		finally{
			DB.close(con, pst);
		}
		return rs;
	}

	@Override
	public int insert(Comment c) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		Object obj[]={c.getCommentUserId(),c.getCommentContent(),c.getCommentDate(),c.getCommentTime()};
		String sql="insert into Comment(comment_user_id,comment_content,comment_date,comment_time) values(?,?,?,?)";
		try{
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=DB.executeUpdate(pst);
			System.out.println("≤Â»Î≥…π¶");
		}
		finally{
			DB.close(con, pst);
		}
		return rs;
	}
	@Override
	public int insertImageComment(String param[]) throws SQLException {
		// TODO Auto-generated method stub
		
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		String sql="insert into Comment(comment_user_id,comment_content,comment_date,image_path,comment_time) values(?,?,?,?,?)";
		DB.executeSQL(sql, param);
		return rs;
	}
	
	
}
