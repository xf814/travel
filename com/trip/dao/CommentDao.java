package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Comment;


public interface CommentDao {
   public ArrayList<Comment> query(int id)throws SQLException;
   public int delete(int id)throws SQLException;
   public int insert(Comment c)throws SQLException;
   public int insertImageComment(String[] param) throws SQLException;
   public ArrayList<Comment> query() throws SQLException;
   
   
}
