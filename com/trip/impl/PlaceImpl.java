package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.PlaceDao;
import com.trip.db.DB;
import com.trip.domain.Place;


public class PlaceImpl implements PlaceDao{
   @Override
	public Place queryByPlace(String place)throws SQLException{
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		Place p=null;
		String sql="select * from Place where place=?";
		con=DB.connect();
		pst=con.prepareStatement(sql);
		pst.setString(1, place);
		rs=DB.getResultSet(pst);
		if(rs.next()){
			p=new Place(rs.getString(1),rs.getString(2), rs.getString(4),rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11),rs.getString(12));
		}
		
		return p;
		
	}

	@Override
	public ArrayList<Place> queryByCity(String city) throws SQLException {
		ArrayList<Place> ap =null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="select place,place_jianjie,img_patten,place_tieshi,place_menpiao,place_shijian,place_jiaotong,place_jiage,place_pingfen,place_dizhi from Place where city = ?";
		try{
			con=DB.connect();
			pst=con.prepareStatement(sql);
			pst.setString(1,city);
			rs=DB.getResultSet(pst);
			ap =new ArrayList<Place>();
			while(rs.next()){
				System.out.println("гаЪ§Он");
				ap.add(new Place(city,rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),  rs.getString(8), rs.getString(9),rs.getString(10)));
			}
		}finally{
			DB.close(con, pst, rs);
		}
		System.out.println(ap);
		return ap;
		
	}

	/*@Override
	public int insert(Place p) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql=null;
		Object obj[] = {p.getCity(),p.getPlace(),p.getPlaceId(),p.getDescribe()};
		sql="insert into Place (city,place,place_id,describe) values(?,?,?,?)";
		try {
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=DB.executeUpdate(pst);
			 } finally {
		            DB.close(con, pst);
	                  }
	           return rs;
		
	}*/
  
}
