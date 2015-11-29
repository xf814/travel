package com.trip.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDaoArray {

	//驱动类和数据源
	private static final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	
	//数据库连接对象
	private static Connection connection;
	
	//SQL 执行对象
	private static PreparedStatement statement;
	
	//RS记录集
	private static ResultSet rSet;
	
	// 连接url
	protected static String url = "jdbc:sqlserver://10.3.129.72:1433;databaseName=trip"; 

	// 数据库用户名
	protected static String dbUser = "sa"; 

	// 数据库密码
	protected static String dbPwd = "54321"; 
	
	/**
	 * 得到数据库连接对象 
	 * @return 数据库连接对象
	 */
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(url, dbUser, dbPwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("驱动类加载失败！请检查驱动程序!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("数据源配置有误!请检查数据源配置！");
		}
		return connection;
	}
	
	
	/**
	 * 执行数据 增 删 改 的操作
	 * @return 受影响的行数
	 */
	public int executeSQL(String sql,String param[]){
		//默认返回受影响的行数为0
		int res = 0;
		//得到数据库连接对象
		connection = getConnection();
		try {
			//得到SQL 执行对象
			statement = connection.prepareStatement(sql);
			//设置参数
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					statement.setString(i+1, param[i]);
				}
			}
			//执行SQL 
			res = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行数据库增 删 改 操作失败！");
		}finally{
			
		}
		//返回受影响的行数
		return res;
	}
	
	/**
	 * 执行查询 返回单行单列的数据
	 * @param sql
	 * @param param
	 * @return 返回第一行第一列的值
	 */
	public  String executeObject(String sql,String param[]){
		String value ="";
		//得到数据库连接对象
		connection = getConnection();
		try {
			//得到SQL 执行对象
			statement = connection.prepareStatement(sql);
			//设置参数
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					statement.setString(i+1, param[i]);
				}
			}
			//执行SQL 
			rSet = statement.executeQuery();
			while (rSet.next()) {
				value = rSet.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行数据库增 删 改 操作失败！");
		}finally{
			closeResources(rSet, statement, connection);
		}
		return value;
	}
	
	/**
	 * 关闭数据库资源对象
	 * @param rs 记录集
	 * @param statement SQL 执行对象
	 * @param connection 数据库连接对象
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
			System.out.println("关闭数据库资源时发生错误！");
		}
	}
	
}
