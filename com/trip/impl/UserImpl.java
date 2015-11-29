package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.trip.dao.UserDao;
import com.trip.db.DB;
import com.trip.domain.User;

public class UserImpl implements UserDao {

	@Override
	public ArrayList<User> query(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<User> au = new ArrayList<User>();
		sql = "select * from Users where user_id=?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = DB.getResultSet(pst);
			while (rs.next()) {
				au.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), rs.getDate(6), rs
								.getString(7), rs.getString(8)));
			}
		} finally {

			DB.close(con, pst, rs);

		}
		return au;
	}

	// 用户详细信息
	@Override
	public String queryUserInfo(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		String info = null;
		sql = "select * from Users where user_id=?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = DB.getResultSet(pst);
			while (rs.next()) {
				info = rs.getString(4) + "," + rs.getString(7) + ","
						+ rs.getString(5) + "," + rs.getString(11) + ","
						+ rs.getString(8) + "," + rs.getString(3) + ","
						+ rs.getString(10) + "," + rs.getString(12) + ","
						+ rs.getDate(6) + "," + rs.getString(9);
			}
		} finally {
			DB.close(con, pst, rs);
		}
		return info;
	}

	@Override
	public int update(User u, int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int rs = -1;
		String sql = null;
		Object obj[] = { u.getUserPassword(), u.getUserEmail(),
				u.getUserNickname(), u.getUserSex(), u.getUserRealname(),
				u.getUserTele(), id };
		sql = "update User set user_password=?,user_email=?,user_nickname=?,user_sex=?,user_realname=?,user_tele=? where user_id=?";
		try {
			con = DB.connect();
			pst = DB.getPreparStatement(sql, con, obj);
			rs = pst.executeUpdate();

		} finally {
			DB.close(con, pst);
		}
		return rs;

	}

	@Override
	public boolean login(String nickname, String password) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from Users where user_nickname = ? and user_password = ?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setString(1, nickname);
			pst.setString(2, password);
			rs = DB.getResultSet(pst);
			if (rs.next()) {
				return true;
			}
		} finally {

			DB.close(con, pst, rs);

		}
		return false;
	}

	@Override
	public int insert(User u) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		int rs = -1;
		String sql = null;
		Object obj[] = { u.getUserPassword(), u.getUserEmail(),
				u.getUserNickname(), u.getUserSex(),
				new Timestamp(u.getUserRegisterdate().getTime()),
				u.getUserRealname(), u.getUserTele() };
		sql = "insert into Users (user_password,user_email,user_nickname,user_sex,user_registerdate,user_realname,user_tele) values(?,?,?,?,?,?,?)";
		try {
			System.out.println(obj.length);
			con = DB.connect();
			pst = DB.getPreparStatement(sql, con, obj);
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}
		return rs;

	}

	@Override
	public int findId(String userName) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		int userId = 0;
		sql = "select user_id from Users where user_nickname = ?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			rs = DB.getResultSet(pst);
			if (rs.next())
				userId = rs.getInt(1);
		} finally {
			DB.close(con, pst, rs);
		}
		return userId;
	}

	@Override
	public String findName(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		String userNickName = null;
		sql = "select user_nickname from Users where user_id = ?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = DB.getResultSet(pst);
			if (rs.next())
				userNickName = rs.getString(1);
		} finally {
			DB.close(con, pst, rs);
		}
		return userNickName;
	}

	@Override
	public String findPhoto(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		String userPhoto = null;
		sql = "select user_photo from Users where user_id = ?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = DB.getResultSet(pst);
			if (rs.next())
				userPhoto = rs.getString(1);
		} finally {
			DB.close(con, pst, rs);
		}
		return userPhoto;
	}

	@Override
	public String findIntro(int id) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		String userIntro = null;
		sql = "select user_intro from Users where user_id = ?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = DB.getResultSet(pst);
			if (rs.next())
				userIntro = rs.getString(1);
		} finally {
			DB.close(con, pst, rs);
		}
		return userIntro;
	}

	@Override
	public ArrayList<User> queryFriend(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList<User> FriendsId = new ArrayList<User>();
		sql = " select user_id,user_nickname,user_intro from Users  where user_id not in (select followed_id from Attention where follow_id=?  or followed_id=?)";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setInt(2, id);
			rs = DB.getResultSet(pst);
			while (rs.next()) {
				FriendsId.add(new User(rs.getInt(1), rs.getString(2), rs
						.getString(3)));
			}
		} finally {

			DB.close(con, pst, rs);

		}
		return FriendsId;
	}

	@Override
	public ArrayList queryFriendId(int userId) throws SQLException {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = null;
		ArrayList al = new ArrayList();
		sql = " select user_id from Users where user_id not in (select followed_id from Attention where follow_id=? or followed_id=?)";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, userId);
			rs = DB.getResultSet(pst);
			while (rs.next()) {
				al.add(new Integer(rs.getInt(1)));
			}
		} finally {
			DB.close(con, pst);
		}
		System.out.println("al::::::::::" + al);
		return al;
	}

}
