package com.tedu.huat.util;
/**
 * 数据库的工具类
 * @author 马坤
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	//数据库的url地址
	private static String url = "jdbc:mysql://localhost:3306/huat";
	//数据库的用户名
	private static String username = "root";
	//数据库的密码吗
	private static String pwd = "root";
	//数据库的地址
	private static String driver = "com.mysql.jdbc.Driver";
	
	//化的数据库的链接
	public static Connection getConn() throws Exception{
		//加载驱动
		Class.forName(driver);
		return DriverManager.getConnection(url,username,pwd);
	}
	public static void main(String[] args) throws Exception{
		System.out.println(getConn());
	}
}	
