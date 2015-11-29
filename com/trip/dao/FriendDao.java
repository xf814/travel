package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Friend;


public interface FriendDao {
       public ArrayList<Friend> query(int id) throws SQLException;
       public int delete(int userId,int friendId) throws SQLException;
       public int add(Friend f) throws SQLException;
       public int update(Friend f,int id) throws SQLException;
       
}
