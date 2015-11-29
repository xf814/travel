package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.AdminDao;
import com.trip.db.DB;
import com.trip.domain.Admin;


public class AdminImpl implements AdminDao{

	@Override
	public ArrayList<Admin> query(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql=null;
		ArrayList<Admin> aa=new ArrayList<Admin>();
		sql="select * from Admin where admin_id=?";
		try {
		con=DB.connect();
		pst=con.prepareStatement(sql);
		pst.setInt(1, id);
		rs=DB.getResultSet(pst);
		while(rs.next()){
			aa.add(new Admin(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
					rs.getString(5),rs.getString(6),rs.getString(7)));
		}
		}
		finally {

			DB.close(con, pst, rs);

		}
		return aa;
	}

	@Override
	public int update(Admin a, int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		Object obj[] = {a.getAdminPassword(),a.getAdminEmail(),a.getAdminNickname(),a.getAdminSex(),a.getAdminRealname(),a.getAdminTele(),id };
		sql="update Admin set admin_password=?,admin_email=?,admin_nickname=?,admin_sex=?,admin_regiestdate=?,admin_realname=?,admin_tele=? where admin_id=?";
		try {
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=pst.executeUpdate();	
		
	        } finally {
		            DB.close(con, pst);
	                  }
	           return rs;
		
	}

	@Override
	public int insert(Admin a) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		Object obj[] = {a.getAdminId(),a.getAdminPassword(),a.getAdminEmail(),a.getAdminNickname(),a.getAdminSex(),a.getAdminRealname(),a.getAdminTele()};
		sql="insert into User (admin_id,admin_password,admin_email,admin_nickname,admin_sex,admin_realname,admin_tele) values(?,?,?,?,?,?,?)";
		try {
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=DB.executeUpdate(pst);
			 } finally {
		            DB.close(con, pst);
	                  }
	           return rs;
		
	}
}
