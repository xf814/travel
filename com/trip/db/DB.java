package com.trip.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*问题:建立数据库连接
 * 
 * 思路：数据库连接首先要加载数据库驱动，然后建立数据库开启和关闭方法
 * 
 */

public class DB {
	private static String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 存储数据库驱动名称
	private static String databaseURL = "jdbc:sqlserver://localhost:1433;DatabaseName = trip";// 加载数据库类型，数据库URL，数据库名称
	private static String user = "sa";
	private static String password = "54321";

	public static Connection connect() {// 抛出SQL异常
		Connection con = null;// 创建连接实例

		// 开始装载驱动

		try {// 检测异常
			Class.forName(driverName);
			System.out.println("加载数据库驱动成功");// 在控制台打印加载成功信息，可以注释隐藏
		} catch (ClassNotFoundException e) {// 对于类文件未找到异常进行控制台输出告知，并处理异常
			// TODO 自动生成的 catch 块
			System.out.println("加载数据库驱动失败");// 在控制台打印加载失败信息，可以注释隐藏
			e.printStackTrace();// 打印类未找到异常
		}

		// 加载驱动类，通过驱动程序管理器建立与数据库的连接

		try {
			con = DriverManager.getConnection(databaseURL, user, password);// 调用getConnection方法获得到数据库的连接
			System.out.println("连接成功！");
		} catch (SQLException e) {// 抓取异常
			// TODO 自动生成的 catch 块
			System.out.println("连接失败！");//
			e.printStackTrace();
		}
		return con;
	}

	// 获取数据库操作语句,其中，con是连接对象，SQL是数据库语句
	public static PreparedStatement getPreparStatement(String sql,
			Connection con, Object[] arge) throws NullPointerException {// 如果con为空，以下代码可能抛出NullPointerException(空指针异常)
		PreparedStatement pst = null;// 创建一个预编译SQL语句对象
		if (con != null) {// 判断con变量是否为空，不为空，则执行导入语句
			try {
				pst = con.prepareStatement(sql);// 导入SQL语句
				if (arge != null)// 如果arge数组为空，则不导入参数
					for (int i = 0; i < arge.length; i++) {// 导入SQL参数
						pst.setObject(i + 1, arge[i]);

					}
			} catch (SQLException e) {
				System.out.println("sql语句赋值失败");
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} else
			throw new NullPointerException();// con为空，连接对象不存在，抛出空指针异常

		return pst;
	}

	// 执行查询的数据库操作

	public static ResultSet getResultSet(PreparedStatement pst)
			throws NullPointerException {// 如果pst为空，以下代码可能抛出NullPointerException(空指针异常)
		ResultSet rs = null;// 创建一个rs集合对象
		if (pst != null) {// 判断pst对象是否为空
			try {
				rs = pst.executeQuery();// 执行SQL语句
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				System.out.println("执行SQL语句失败");
				e.printStackTrace();
			}
		} else
			throw new NullPointerException();// pst对象不存在，抛出空指针异常
		return rs;
	}

	// 非查询的数据库操作
	public static int executeUpdate(PreparedStatement pst)
			throws NullPointerException {// 如果pst为空，以下代码可能抛出NullPointerException(空指针异常)
		int rs = -1;
		if (pst != null) {
			try {
				rs = pst.executeUpdate();// 执行SQL语句
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				System.out.println("执行SQL语句失败");
				e.printStackTrace();
			}
		} else
			new NullPointerException();// pst对象不存在，抛出空指针异常
		return rs;
	}

	// 数据库关闭方法
	public static void close(Connection con) throws SQLException {// 当只有con对象的数据库关闭
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
		//默认返回受影响的行数为0
		int res = 0;
		//得到数据库连接对象
		Connection con=null;
		PreparedStatement pst=null;
		con=DB.connect();
		try {
			//得到SQL 执行对象
			pst=con.prepareStatement(sql);
			//设置参数
			if(param!=null){
				for (int i = 0; i < param.length; i++) {
					pst.setString(i+1, param[i]);
				}
			}
			//执行SQL 
			res = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行数据库增 删 改 操作失败！");
		}finally{
			
		}
		//返回受影响的行数
		return res;
	}
	
}
