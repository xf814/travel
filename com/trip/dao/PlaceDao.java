package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Place;



public interface PlaceDao {
   //public ArrayList<PlaceDao> query(String city) throws SQLException;
   //public int insert(Place p) throws SQLException;
   public ArrayList<Place> queryByCity(String city) throws SQLException;

   public Place queryByPlace(String place) throws SQLException;
   
}
