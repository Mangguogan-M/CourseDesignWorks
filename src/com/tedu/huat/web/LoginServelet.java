package com.tedu.huat.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tedu.huat.dao.UserDao;
import com.tedu.huat.dao.UserDaoImpl;
import com.tedu.huat.pojo.User;

@WebServlet("/LoginServelet")
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置请求编号
		request.setCharacterEncoding("utf-8");
		// 设置响应编码
		response.setContentType("text/html;charset=utf-8");
		// 得到用户登陆的用户名密码，引号对应name="username"
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		// 查询数据库，如果正确跳转主页面，失败回调登陆界面
		UserDao dao = new UserDaoImpl();
		try {
			User u = dao.login(username, pwd);
			List<User> list = dao.findAll();// 插寻所有用户
			// 获取session
			HttpSession session = request.getSession();
			// 用户部位空，说明存在用户
			if (u != null) {
				session.setAttribute("u", u);
				session.setAttribute("list", list);
				request.getRequestDispatcher("main.jsp").forward(request, response);
			} else {
				response.sendRedirect("login.html");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
