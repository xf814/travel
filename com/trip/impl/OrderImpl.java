package com.trip.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.trip.dao.OrderDao;
import com.trip.db.DB;
import com.trip.domain.Order;

public class OrderImpl implements OrderDao {
	@Override
	public int insert(Order o) throws SQLException {
		Object[] obj = {o.getOrderId(),o.getOrderMoney(),o.getOrderHotel(),new Timestamp(o.getOrderBookdDay().getTime()),o.getOrderDays(),o.getUserId()};
		Connection con=null;
		PreparedStatement pst=null;
		int rs =-1;
		String sql="insert into Orders (order_id,order_money,order_hotel,order_bookday,order_days,user_id) values(?,?,?,?,?,?)";
		try {
			System.out.println(obj.length);
			con=DB.connect();
			pst=DB.getPreparStatement(sql, con, obj);
			rs=DB.executeUpdate(pst);
			 } finally {
		            DB.close(con, pst);
	                  }
		return rs;
		
	} 
}
