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
 * Servlet implementation class RegistServelet
 */
@WebServlet("/RegistServelet")
public class RegistServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 设置编码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// 得到用户输入的参数
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		char gendar = request.getParameter("gendar").charAt(0);
		// 注册用户
		User u = new User(username, pwd, nickname, gendar, age, phone);
		UserDao dao = new UserDaoImpl();
		try {
			boolean b = dao.save(u);
			if (b) {// 插入成功,绑定用户名，转发三秒以后自动跳转页面
				request.setAttribute("name", nickname);
				request.getRequestDispatcher("success_1.jsp").forward(request, response);
			}
		} catch (Exception e) {// 插入失败，一般都是重新跳转注册页面
			e.printStackTrace();
			response.getWriter().println("插入失败！<a href = 'myregist.html'>点击重新注册</a>");
		}
	}

}
