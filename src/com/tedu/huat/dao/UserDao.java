package com.tedu.huat.dao;

import java.util.List;

import com.tedu.huat.pojo.User;

/**
 * data access object
 * 用户的数据访问对象
 * @author 马坤
 *
 */
public interface UserDao {
	//判断用户户名是否被注册
	User findByName(String username)throws Exception;//早抛出，晚处理
	//注册用户
	boolean save(User u) throws Exception;
	//登陆
	public User login(String username, String pwd)throws Exception;
	//查询当前数据库中的所有元素
	public List<User> findAll() throws Exception;
	
	
}
