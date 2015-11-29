package com.trip.test;

import java.sql.Connection;
import java.sql.SQLException;

import com.trip.dao.BaseDaoArray;

public class DBTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = new BaseDaoArray().getConnection();
		System.out.println(con);
		con.close();
	}

}
