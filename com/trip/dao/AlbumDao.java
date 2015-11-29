package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Album;



public interface AlbumDao {
	  public int insert(Album a)throws SQLException;
	   public int delete(Album a,int userId,int albumId)throws SQLException;
	   public ArrayList<Album> query(int userId)throws SQLException;
	   public int update(Album a,int userId,int albumId)throws SQLException;
}
