package com.trip.logic;

import java.sql.SQLException;

import Factory.DaoFactory;

import com.trip.domain.Comment;

public class setImages {
	private int userId=0;
	private Comment c=null;
     public void setCircle(String content,String userName,String filePath,String date ,String time ){
    	 
    	    
			try {
				userId=DaoFactory.getUserDaoInstance().findId(userName);
			} catch (SQLException e1) {
				// TODO �Զ����ɵ� catch ��
				e1.printStackTrace();
			}
			c=new Comment(userId,content,date,time);
	        try {
				DaoFactory.getCommentDaoInstance().insert(c);
				
				
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
     }
}
