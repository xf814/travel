package com.trip.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trip.dao.BaseDaoArray;
import com.trip.domain.Travel;

public class TravelDao extends BaseDaoArray {
	// ���ݿ����Ӷ���
	private Connection connection;
	// SQL ִ�ж���
	private PreparedStatement statement;
	// RS��¼��
	private ResultSet rSet;

	BaseDaoArray basedao;
	TravelDao travelDao;

	/**
	 * �õ�������Ϣ����
	 * 
	 * @return ʵ���༯�϶���
	 */
	public ArrayList<Travel> getTravelList(String sql, String param[]) {
		// ���϶���
		ArrayList<Travel> list = new ArrayList<Travel>();
		try {
			basedao = new BaseDaoArray();
			// �õ����ݿ����Ӷ���
			this.connection = basedao.getConnection();
			// SQL ִ�ж���
			this.statement = connection.prepareStatement(sql);
			// ���ò���
			if (param != null) {
				for (int i = 0; i < param.length; i++) {
					statement.setString(i + 1, param[i]);
				}
			}
			// ��ѯ�õ����ݼ�����
			this.rSet = statement.executeQuery();
			
			// ѭ���õ�ʵ����
			while (rSet.next()) {
				Travel Travel = new Travel();
				// ��װ����
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
				
				// ��ӵ�������
				list.add(Travel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("��ѯ����ʱ��������");
		}
		return list;
	}

	// ���÷���ȥ�õ����ݿ����������ݵļ���
	public ArrayList<Travel> getTravelList() {
		String sql = "select * from travel";
		ArrayList<Travel> list = getTravelList(sql, null);
		return list;
	}

	/**
	 * �õ�����������
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
	 * ���һ���µļ�¼
	 */
	public int insertTravel(String param[]) {
		int res = 0;
		String sql = "insert into travel values(?,?,?,?,?)";
		travelDao = new TravelDao();
		res = travelDao.executeSQL(sql, param);
		return res;
	}

	/**
	 * ��������
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
	 * ɾ����Ϣ
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
