package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Track;


public interface TrackDao {
    public ArrayList<Track> query(int id)throws SQLException;
    public int update(Track t, int userId,int trackId)throws SQLException;
    public int delete(int userId,int trackId)throws SQLException;
    public int insert(Track t)throws SQLException;	
}
