package com.trip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDaoArray {

	//�����������Դ
	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	//���ݿ����Ӷ���
	private static Connection connection;
	
	//SQL ִ�ж���
	private static PreparedStatement statement;
	
	//RS��¼��
	private static ResultSet rSet;
	
	// ����url
	protected static String url = "jdbc:sqlserver://10.3.129.72:1433;databaseName=trip"; 

	// ���ݿ��û���
	protected static String dbUser = "sa"; 

	// ���ݿ�����
	protected static String dbPwd = "54321"; 
	
	/**
	 * �õ����ݿ����Ӷ��� 
	 * @return ���ݿ����Ӷ���
	 */
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(url, dbUser, dbPwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("���������ʧ�ܣ�������������!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("����Դ��������!��������Դ���ã�");
		}
		return connection;
	}
	
	
	/**
	 * ִ������ �� ɾ �� �Ĳ���
	 * @return ��Ӱ�������
	 */
	public int executeSQL(String sql,String param[]){
		//Ĭ�Ϸ�����Ӱ�������Ϊ0
		int res = 0;
		//�õ����ݿ����Ӷ���
		connection = getConnection();
		try {
			//�õ�SQL ִ�ж���
			statement = connection.prepareStatement(sql);
			//���ò���
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					statement.setString(i+1, param[i]);
				}
			}
			//ִ��SQL 
			res = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ִ�����ݿ��� ɾ �� ����ʧ�ܣ�");
		}finally{
			
		}
		//������Ӱ�������
		return res;
	}
	
	/**
	 * ִ�в�ѯ ���ص��е��е�����
	 * @param sql
	 * @param param
	 * @return ���ص�һ�е�һ�е�ֵ
	 */
	public  String executeObject(String sql,String param[]){
		String value ="";
		//�õ����ݿ����Ӷ���
		connection = getConnection();
		try {
			//�õ�SQL ִ�ж���
			statement = connection.prepareStatement(sql);
			//���ò���
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					statement.setString(i+1, param[i]);
				}
			}
			//ִ��SQL 
			rSet = statement.executeQuery();
			while (rSet.next()) {
				value = rSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ִ�����ݿ��� ɾ �� ����ʧ�ܣ�");
		}finally{
			closeResources(rSet, statement, connection);
		}
		return value;
	}
	
	/**
	 * �ر����ݿ���Դ����
	 * @param rs ��¼��
	 * @param statement SQL ִ�ж���
	 * @param connection ���ݿ����Ӷ���
	 */
	public static void closeResources(ResultSet rs,PreparedStatement statement,Connection connection){
		try {
			if (rs!=null) {
				rs.close();
			}
			if (statement!=null) {
				statement.close();
			}
			if (connection!=null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("�ر����ݿ���Դʱ��������");
		}
	}
	
}
