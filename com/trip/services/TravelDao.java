package com.trip.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.BaseDaoArray;
import com.trip.domain.Travel;

public class TravelDao extends BaseDaoArray {
	// 数据库连接对象
	private Connection connection;
	// SQL 执行对象
	private PreparedStatement statement;
	// RS记录集
	private ResultSet rSet;

	BaseDaoArray basedao;
	TravelDao travelDao;

	/**
	 * 得到数据信息集合
	 * 
	 * @return 实体类集合对象
	 */
	public ArrayList<Travel> getTravelList(String sql, String param[]) {
		// 集合对象
		ArrayList<Travel> list = new ArrayList<Travel>();
		try {
			basedao = new BaseDaoArray();
			// 得到数据库连接对象
			this.connection = basedao.getConnection();
			// SQL 执行对象
			this.statement = connection.prepareStatement(sql);
			// 设置参数
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					statement.setString(i + 1, param[i]);
				}
			}
			// 查询得到数据集对象
			this.rSet = statement.executeQuery();
			
			// 循环得到实体类
			while (rSet.next()) {
				Travel Travel = new Travel();
				// 封装数据
				Travel.setId(rSet.getLong(1));
				Travel.setContent(rSet.getString(2).trim());
				Travel.setDate(rSet.getString(3).trim());
				Travel.setImagepath(rSet.getString(4).trim());
				Travel.setTime(rSet.getString(5).trim());
				Travel.setAddress(rSet.getString(6).trim());
				
//				System.out.println("[" + rSet.getLong(1) + "]" + "("
//						+ rSet.getString(2).trim() + ")" + "{"
//						+ rSet.getString(3).trim() + "}" +"--"
//						+ rSet.getString(4).trim() + "--"+"<"
//						+ rSet.getString(5).trim() +">"  +"?"
//						+ rSet.getString(6).trim() +"?");
				
				// 添加到集合中
				list.add(Travel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查询数据时发生错误！");
		}
		return list;
	}

	// 调用方法去得到数据库中所有数据的集合
	public ArrayList<Travel> getTravelList() {
		String sql = "select * from travel";
		ArrayList<Travel> list = getTravelList(sql, null);
		return list;
	}

	/**
	 * 得到单条的数据
	 */
	public Travel getTravelByDepa_name(String depa_name) {
		System.out.println("depa_name:" + depa_name);
		Travel Travel = new Travel();
		String sql = "select * from travel where depa_name =?";
		String param[] = new String[] { depa_name };
		ArrayList<Travel> list = getTravelList(sql, param);
		if (list.size() != 0) {
			Travel = list.get(0);
		}
		return Travel;
	}

	/**
	 * 添加一条新的记录
	 */
	public int insertTravel(String param[]) {
		int res = 0;
		String sql = "insert into travel values(?,?,?,?,?)";
		travelDao = new TravelDao();
		res = travelDao.executeSQL(sql, param);
		return res;
	}

	/**
	 * 更新数据
	 * 
	 */
	public int updateTravel(String depa_name, String depa_manager,
			String depa_phone, String depa_introduce,
			String depa_office_address, String depa_id) {
		int res = 0;
		String sql = "update Travel set depa_name=?,depa_manager=?,depa_phone=?,depa_introduce=?, depa_office_address=? where depa_id="
				+ depa_id;
		String param[] = new String[] { depa_name, depa_manager, depa_phone,
				depa_introduce, depa_office_address };

		travelDao = new TravelDao();
		res = travelDao.executeSQL(sql, param);
		return res;
	}

	/**
	 * 删除信息
	 */
	public int deleteTravel(String depa_id) {
		int res = 0;
		String sql = "delete from Travel where depa_id=?";
		String param[] = new String[] { depa_id };

		travelDao = new TravelDao();
		res = travelDao.executeSQL(sql, param);
		return res;
	}
}
