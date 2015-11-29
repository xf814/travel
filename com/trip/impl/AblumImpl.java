package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.AlbumDao;
import com.trip.db.DB;
import com.trip.domain.Album;


public class AblumImpl implements AlbumDao{

	@Override
	public int insert(Album a) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		Object obj[] ={a.getAlbumId(),a.getAlbumDate(),a.getAlbumUserId(),a.getAlbumDescribe(),a.getAlbumname()};
		String sql="insert into Album(album_id,album_date,album_user_id,album_describe,album_name) values(?,?,?,?,?)";
		try{
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=pst.executeUpdate();
		}
		finally{
			DB.close(con, pst);
		}
		return rs;
	}

	@Override
	public int delete(Album p, int userId, int albumId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		String sql="delete * from Album where album_user_id=?,album_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2,albumId);
			
			rs=DB.executeUpdate(pst);
			
		}
		finally{
			DB.close(con, pst);
		}
		return rs;
	}
	@Override
	public ArrayList<Album> query(int userId) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Album> aa=new ArrayList<Album>();
		String sql="select * from Album where Album_user_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1,userId);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	aa.add(new Album(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
		   
		    }
		    
		}
		finally{
			DB.close(con, pst);
		}
		
		return null;
	}

	@Override
	public int update(Album a, int userId, int albumId) throws SQLException {
		// TODO Auto-generated method stub
	Connection con=null;
	PreparedStatement pst=null;
	int rs=-1;
	Object obj[] ={a.getAlbumDate(),a.getAlbumDescribe(),a.getAlbumname(),userId,albumId};
	String sql="update Album set album_date=?,album_describe=?,album_name=? where album_user_id=?,album_id=? ";
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
	

}
