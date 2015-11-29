package com.trip.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*����:�������ݿ�����
 * 
 * ˼·�����ݿ���������Ҫ�������ݿ�������Ȼ�������ݿ⿪���͹رշ���
 * 
 */

public class DB {
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // �洢���ݿ���������
	private static String databaseURL = "jdbc:sqlserver://localhost:1433;DatabaseName = trip";// �������ݿ����ͣ����ݿ�URL�����ݿ�����
	private static String user = "sa";
	private static String password = "54321";

	public static Connection connect() {// �׳�SQL�쳣
		Connection con = null;// ��������ʵ��

		// ��ʼװ������

		try {// ����쳣
			Class.forName(driverName);
			System.out.println("�������ݿ������ɹ�");// �ڿ���̨��ӡ���سɹ���Ϣ������ע������
		} catch (ClassNotFoundException e) {// �������ļ�δ�ҵ��쳣���п���̨�����֪���������쳣
			// TODO �Զ����ɵ� catch ��
			System.out.println("�������ݿ�����ʧ��");// �ڿ���̨��ӡ����ʧ����Ϣ������ע������
			e.printStackTrace();// ��ӡ��δ�ҵ��쳣
		}

		// ���������࣬ͨ������������������������ݿ������

		try {
			con = DriverManager.getConnection(databaseURL, user, password);// ����getConnection������õ����ݿ������
			System.out.println("���ӳɹ���");
		} catch (SQLException e) {// ץȡ�쳣
			// TODO �Զ����ɵ� catch ��
			System.out.println("����ʧ�ܣ�");//
			e.printStackTrace();
		}
		return con;
	}

	// ��ȡ���ݿ�������,���У�con�����Ӷ���SQL�����ݿ����
	public static PreparedStatement getPreparStatement(String sql,
			Connection con, Object[] arge) throws NullPointerException {// ���conΪ�գ����´�������׳�NullPointerException(��ָ���쳣)
		PreparedStatement pst = null;// ����һ��Ԥ����SQL������
		if (con != null) {// �ж�con�����Ƿ�Ϊ�գ���Ϊ�գ���ִ�е������
			try {
				pst = con.prepareStatement(sql);// ����SQL���
				if (arge != null)// ���arge����Ϊ�գ��򲻵������
					for (int i = 0; i < arge.length; i++) {// ����SQL����
						pst.setObject(i + 1, arge[i]);

					}
			} catch (SQLException e) {
				System.out.println("sql��丳ֵʧ��");
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		} else
			throw new NullPointerException();// conΪ�գ����Ӷ��󲻴��ڣ��׳���ָ���쳣

		return pst;
	}

	// ִ�в�ѯ�����ݿ����

	public static ResultSet getResultSet(PreparedStatement pst)
			throws NullPointerException {// ���pstΪ�գ����´�������׳�NullPointerException(��ָ���쳣)
		ResultSet rs = null;// ����һ��rs���϶���
		if (pst != null) {// �ж�pst�����Ƿ�Ϊ��
			try {
				rs = pst.executeQuery();// ִ��SQL���
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				System.out.println("ִ��SQL���ʧ��");
				e.printStackTrace();
			}
		} else
			throw new NullPointerException();// pst���󲻴��ڣ��׳���ָ���쳣
		return rs;
	}

	// �ǲ�ѯ�����ݿ����
	public static int executeUpdate(PreparedStatement pst)
			throws NullPointerException {// ���pstΪ�գ����´�������׳�NullPointerException(��ָ���쳣)
		int rs = -1;
		if (pst != null) {
			try {
				rs = pst.executeUpdate();// ִ��SQL���
			} catch (SQLException e) {
				// TODO �Զ����ɵ� catch ��
				System.out.println("ִ��SQL���ʧ��");
				e.printStackTrace();
			}
		} else
			new NullPointerException();// pst���󲻴��ڣ��׳���ָ���쳣
		return rs;
	}

	// ���ݿ�رշ���
	public static void close(Connection con) throws SQLException {// ��ֻ��con��������ݿ�ر�
		con.close();
	}

	public static void close(Connection con, PreparedStatement pst)
			throws SQLException {
		pst.close();
		con.close();
	}

	public static void close(Connection con, PreparedStatement pst, ResultSet rs)
			throws SQLException {
		rs.close();
		pst.close();
		con.close();
	}

	public static int executeSQL(String sql,String param[]){
		//Ĭ�Ϸ�����Ӱ�������Ϊ0
		int res = 0;
		//�õ����ݿ����Ӷ���
		Connection con=null;
		PreparedStatement pst=null;
		con=DB.connect();
		try {
			//�õ�SQL ִ�ж���
			pst=con.prepareStatement(sql);
			//���ò���
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					pst.setString(i+1, param[i]);
				}
			}
			//ִ��SQL 
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ִ�����ݿ��� ɾ �� ����ʧ�ܣ�");
		}finally{
			
		}
		//������Ӱ�������
		return res;
	}
	
}
