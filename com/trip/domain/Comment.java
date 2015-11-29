package com.trip.domain;

import java.util.Date;

public class Comment {
     private int circleId=0;
     private int commentUserId=0;
     private String commentContent=null;
     private String commentDate =null;
     private String commentTime =null;
	public Comment(int commentUserId, String commentContent,
			String commentDate, String commentTime) {
		super();
		this.commentUserId = commentUserId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentTime = commentTime;
	}
	public int getCircleId() {
		return circleId;
	}
	public void setCircleId(int circleId) {
		this.circleId = circleId;
	}
	public int getCommentUserId() {
		return commentUserId;
	}
	public void setCommentUserId(int commentUserId) {
		this.commentUserId = commentUserId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	
	public String getCommentTime() {
		return commentTime;
	}
	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}
	@Override
	public String toString() {
		return  circleId + commentUserId + commentContent+ commentDate + commentTime ;
	}
	
  
}