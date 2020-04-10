package com.tedu.huat.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tedu.huat.dao.UserDao;
import com.tedu.huat.dao.UserDaoImpl;
import com.tedu.huat.pojo.User;

/**
 *根据用户名查询当前用户的servelet
 * Servlet implementation class FindName
 */
@WebServlet("/findName")
public class FindName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//设置请求编码
		request.setCharacterEncoding("utf-8");
		//设置返回数据类型
		response.setContentType("text/html;charset = utf-8");
		//得到用户传递过来的anme1
		String name = request.getParameter("name1");
		//访问数据库，查询数据是否存在
		UserDao dao = new UserDaoImpl();
		try {
			User u = dao.findByName(name);
			if(u == null) {//为空说明该用户未被注册，可以使用
				response.getWriter().println("true");
			}else {//用户存在说明不能使用
				response.getWriter().println("false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
