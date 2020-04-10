package com.tedu.huat.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.tedu.huat.dao.UserDao;
import com.tedu.huat.dao.UserDaoImpl;
import com.tedu.huat.pojo.User;

public class UserTest {
	UserDao dao = new UserDaoImpl();
	@Test
	public void test() throws Exception{
		User u = dao.login("qiaoge", "123456");
		System.out.println(u);
		
		
		
		
		
//		//≤‚ ‘
//		for(char i ='\u4e00'; i < '\u9fa5'; i++) {
//			char c = i;
//			System.out.print(c);
//		}
		
//		User u = dao.findByName("qiaoge");
//		System.out.println(u);
	}

}
