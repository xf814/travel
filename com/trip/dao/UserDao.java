package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.User;



public interface UserDao {
      public ArrayList<User> query(int id) throws SQLException; 
      public int update(User u,int id) throws SQLException;
      public int insert(User user) throws SQLException;
      public boolean login(String nickname,String password) throws SQLException;
	  public int findId(String userName) throws SQLException;
	  public String findPhoto(int id) throws SQLException;
	  public String findName(int id) throws SQLException;
	  public String findIntro(int id) throws SQLException;
	  public String queryUserInfo(int id) throws SQLException;
	  public ArrayList<User> queryFriend(int id) throws SQLException;
	  public ArrayList queryFriendId(int userId) throws SQLException;
}
