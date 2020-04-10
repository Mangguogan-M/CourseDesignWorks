package com.tedu.huat.dao;
/**
 * ���ݷ��ʽӿڵ�ʵ����
 * @author ����
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.tedu.huat.pojo.User;
import com.tedu.huat.util.DBUtil;

public class UserDaoImpl implements UserDao{
	//1���������Ӷ���connection
	Connection conn = null;
	//2����䴦�����
	PreparedStatement ps = null;
	//3�����������
	ResultSet rs = null;
	@Override
	public User findByName(String username) throws Exception {
		//�õ������Ӷ���
		conn = DBUtil.getConn();
		//2��sql���
		String SQL = "select * from t_user where username = ?";
		//3�������䴦�����
		ps = conn.prepareStatement(SQL);
		///4������������ֵ
		ps.setString(1, username);
		//5��ִ��sql����ý����
		rs = ps.executeQuery();
		//6�����������
		User u = null;
		while(rs.next()) {
			u = new User();
			u.setId(rs.getInt("id"));
			u.setUsername(username);
			u.setNickname(rs.getString("nickname"));
			u.setPwd(rs.getString("pwd"));
			u.setAge(rs.getInt("age"));
			u.setGendar(rs.getString("gendar").charAt(0));
			u.setPhone(rs.getString("phone"));
		}
		return u;
	}
	@Override
	public boolean save(User u) throws Exception {
		//1�����Ӷ���
		conn = DBUtil.getConn();
		//sql���
		String SQL = "insert into t_user(username,nickname,pwd,age,gendar,phone) values(?,?,?,?,?,?)";
		//��䴦�����
		ps = conn.prepareStatement(SQL);
		//4��������ֵ
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getNickname());
		ps.setString(3, u.getPwd());
		ps.setInt(4, u.getAge());
		ps.setString(5, u.getGendar()+"");
		ps.setString(6, u.getPhone());
		//5��ִ��sql,i��ʾ�ж��������ݷ����仯
		int i = ps.executeUpdate();
		return i>0;
	}
	@Override
	public User login(String username, String pwd) throws Exception {
		//1���������
		conn = DBUtil.getConn();
		//2��sql���
		String SQL = "select * from t_user where username = ? and pwd = ?";
		//3����䴦�����
		ps = conn.prepareStatement(SQL);
		//4��������ֵ
		ps.setString(1, username);
		ps.setString(2, pwd);
		//5�������ѯ���õ����
		rs = ps.executeQuery();
		//6�����������
		User u = null;
		while(rs.next()) {
			u = new User();
			u.setId(rs.getInt("id"));
			u.setUsername(username);
			u.setNickname(rs.getString("nickname"));
			u.setPwd(pwd);
			u.setAge(rs.getInt("age"));
			u.setGendar(rs.getString("gendar").charAt(0));
			u.setPhone(rs.getString("phone"));
		}
		return u;
	}
	@Override
	public List<User> findAll() throws Exception {
		//1���������
		conn = DBUtil.getConn();
		//2��sql���
		String SQL = "select * from t_user";
		//3�������䴦�����
		ps = conn.prepareStatement(SQL);
		//4�����ڲ���Ҫ����������ֱ�ӻ�ý��
		rs = ps.executeQuery();
		//5�����ݿ�����ж�����Ҫʹ�ü��Ͻ���
		List<User> list = new ArrayList<>();
		//6������
		while(rs.next()) {
			User u = new User();
			u.setId(rs.getInt("id"));
			u.setUsername(rs.getString("username"));
			u.setNickname(rs.getString("nickname"));
			u.setPwd(rs.getString("pwd"));
			u.setAge(rs.getInt("age"));
			u.setGendar(rs.getString("gendar").charAt(0));
			u.setPhone(rs.getString("phone"));
			list.add(u);
		}
		return list;
	}
	
}
