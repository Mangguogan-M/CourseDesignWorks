package com.tedu.huat.util;
/**
 * ���ݿ�Ĺ�����
 * @author ����
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	//���ݿ��url��ַ
	private static String url = "jdbc:mysql://localhost:3306/huat";
	//���ݿ���û���
	private static String username = "root";
	//���ݿ��������
	private static String pwd = "root";
	//���ݿ�ĵ�ַ
	private static String driver = "com.mysql.jdbc.Driver";
	
	//�������ݿ������
	public static Connection getConn() throws Exception{
		//��������
		Class.forName(driver);
		return DriverManager.getConnection(url,username,pwd);
	}
	public static void main(String[] args) throws Exception{
		System.out.println(getConn());
	}
}	
