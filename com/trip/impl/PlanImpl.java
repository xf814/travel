package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.trip.dao.PlanDao;
import com.trip.db.DB;
import com.trip.domain.Plan;


public class PlanImpl implements PlanDao{

	@Override
	public int insert(Plan p) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		Object obj[] ={p.getAuthorName(),new Timestamp(p.getPlanTime().getTime()),p.getPlanPlace(),p.getPlanPlaceTime(),new Timestamp(p.getPlanCreateTime().getTime()),p.getPlanPlaceAdd(),p.getPlanPlaceImg(),p.getCity()};
		String sql="INSERT INTO Plans (author_name,plan_time,plan_place,plan_place_time,plan_create_time,plan_place_add,plan_place_img,plan_city) values (?,?,?,?,?,?,?,?)";
		try{
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=pst.executeUpdate();
		}
		finally{
			DB.close(con, pst);
		}
		return rs;
	}

	@Override
	public int deleteByPlanId(int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		String sql="delete from Plans where plan_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			rs=DB.executeUpdate(pst);
		}
		finally{
			DB.close(con, pst);
		}
		return rs;
	}


	@Override
	public ArrayList<Plan> queryByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Plan> ap=new ArrayList<Plan>();
		String sql="select * from Plans where author_name=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setString(1, name);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	ap.add(new Plan(rs.getString("author_name"),rs.getDate("plan_time"),rs.getString(4),rs.getString(5),rs.getTimestamp(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(1)));
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return ap;
	}
	@Override
	public Plan queryById(int plan_id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Plan p=null;
		String sql="select * from Plans where plan_id=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setInt(1, plan_id);
		    rs=DB.getResultSet(pst);
		    if(rs.next()){
		    	p=new Plan(rs.getString("author_name"),rs.getDate("plan_time"),rs.getString(4),rs.getString(5),rs.getTimestamp(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(1));
		    }
		}
		finally{
			DB.close(con, pst);
		}
		return p;
	}
	@Override
	public ArrayList<Plan> queryPlanIdByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		ArrayList<Plan> ap=new ArrayList<Plan>();
		Plan p=new Plan();
		String sql="select * from Plans where author_name=?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
		    pst.setString(1, name);
		    rs=DB.getResultSet(pst);
		    while(rs.next()){
		    	ap.add(new Plan(rs.getString(2),rs.getDate(3),rs.getString(4),rs.getString(5),rs.getTimestamp(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getInt(1)));
		
		    }
		   
		}
		finally{
			DB.close(con, pst);
		}
		return ap;
	
	}

	/*@Override
	public int update(Plan p, int id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs=-1;
		Object obj[] ={p.getPlanDate(),p.getPlanContent(),p.getPlanCreatTime(),id};
		String sql="update Plan set plan_date=?,plan_content=?,plan_creat_time=? where plan_author_id=? ";
		try{
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=DB.executeUpdate(pst);
		}
		finally{
			DB.close(con, pst);
		}
		return rs;
	}*/

}
