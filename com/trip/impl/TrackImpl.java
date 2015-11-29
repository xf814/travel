package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.TrackDao;
import com.trip.db.DB;
import com.trip.domain.Track;


public class TrackImpl implements TrackDao {

	@Override
	public ArrayList<Track> query(int id) throws SQLException {
		// TODO 自动生成的方法存根
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ArrayList<Track> at = new ArrayList<Track>();
		String sql = "select * from Track where user_id=?";

		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			rs = DB.getResultSet(pst);
			while (rs.next()) {
				at.add(new Track(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs
						.getDate(4)));
			}
		} finally {
			DB.close(con, pst, rs);
		}
		return at;
	}

	@Override
	public int update(Track t, int userId, int trackId) throws SQLException {
		// TODO 自动生成的方法存根
		Connection con = null;
		PreparedStatement pst = null;
		int rs = -1;
		Object obj[] = { t.getTrackDate(), t.getPlaceId(), userId, trackId };
		String sql = "update Track set track_date=? place_id=? where user_id=?,track_id=? ";
		try {
			con = DB.connect();
			pst = DB.getPreparStatement(sql, con, obj);
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}

		return rs;
	}

	@Override
	public int delete(int userId, int trackId) throws SQLException {
		// TODO 自动生成的方法存根
		Connection con = null;
		PreparedStatement pst = null;
		int rs = -1;
		String sql = "delete * from Track where user_id=?,track_id=?";
		try {
			con = DB.connect();
			pst = con.prepareStatement(sql);
			pst.setInt(1, userId);
			pst.setInt(2, trackId);
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}

		return rs;
	}

	@Override
	public int insert(Track t) throws SQLException {
		// TODO 自动生成的方法存根
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		String sql = "insert into Track () values = (?,?,?,?)";
		Object[] obj = { t.getTrackId(), t.getPlaceId(), t.getUserId(),
				t.getTrackDate() };
		try {
			con = DB.connect();
			pst = DB.getPreparStatement(sql, con, obj);
			rs = DB.executeUpdate(pst);
		} finally {
			DB.close(con, pst);
		}
		return rs;
	}

}
