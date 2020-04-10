package com.tedu.huat.dao;
/**
 * 数据访问接口的实现类
 * @author 马坤
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
	//1、数据链接对象connection
	Connection conn = null;
	//2、语句处理对象
	PreparedStatement ps = null;
	//3、结果集对象
	ResultSet rs = null;
	@Override
	public User findByName(String username) throws Exception {
		//得到来链接对象
		conn = DBUtil.getConn();
		//2、sql语句
		String SQL = "select * from t_user where username = ?";
		//3、获得语句处理对象
		ps = conn.prepareStatement(SQL);
		///4、给参数？赋值
		ps.setString(1, username);
		//5、执行sql，获得结果集
		rs = ps.executeQuery();
		//6、解析结果集
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
		//1、链接对象
		conn = DBUtil.getConn();
		//sql语句
		String SQL = "insert into t_user(username,nickname,pwd,age,gendar,phone) values(?,?,?,?,?,?)";
		//语句处理对象
		ps = conn.prepareStatement(SQL);
		//4、参数赋值
		ps.setString(1, u.getUsername());
		ps.setString(2, u.getNickname());
		ps.setString(3, u.getPwd());
		ps.setInt(4, u.getAge());
		ps.setString(5, u.getGendar()+"");
		ps.setString(6, u.getPhone());
		//5、执行sql,i表示有多少行数据发生变化
		int i = ps.executeUpdate();
		return i>0;
	}
	@Override
	public User login(String username, String pwd) throws Exception {
		//1、获得链接
		conn = DBUtil.getConn();
		//2、sql语句
		String SQL = "select * from t_user where username = ? and pwd = ?";
		//3、语句处理对象
		ps = conn.prepareStatement(SQL);
		//4、参数赋值
		ps.setString(1, username);
		ps.setString(2, pwd);
		//5、处理查询，得到结果
		rs = ps.executeQuery();
		//6、迭代结果集
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
		//1、获得链接
		conn = DBUtil.getConn();
		//2、sql语句
		String SQL = "select * from t_user";
		//3、获得语句处理对象
		ps = conn.prepareStatement(SQL);
		//4、由于不需要参数，可以直接获得结果
		rs = ps.executeQuery();
		//5、数据库可能有多项需要使用集合接受
		List<User> list = new ArrayList<>();
		//6、迭代
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
