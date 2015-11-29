package com.trip.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.domain.Attention;

public interface AttentionDao {
	
	public ArrayList<Attention> queryAttentionByUserId(int userId) throws SQLException;
	public ArrayList<Attention> queryFanByUserId(int userId) throws SQLException;
	public int deleteAttention(int AttentionId) throws SQLException;
	public int deleteAttention(int user1Id,int user2Id) throws SQLException;
	public int addAttention(int userId1,int userId2) throws SQLException;
	public int countFollows(int userId) throws SQLException;
	public int countFans(int userId) throws SQLException;
	public ArrayList queryFollowedId(int userId) throws SQLException;
	public String queryTag(int follow_id,int followed_id)throws SQLException;
	public ArrayList queryFollowId(int userId) throws SQLException;
	public String queryAttentionState(int followId,int followedId) throws SQLException;
	}