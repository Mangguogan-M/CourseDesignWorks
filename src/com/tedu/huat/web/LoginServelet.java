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
		// ����������
		request.setCharacterEncoding("utf-8");
		// ������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		// �õ��û���½���û������룬���Ŷ�Ӧname="username"
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		// ��ѯ���ݿ⣬�����ȷ��ת��ҳ�棬ʧ�ܻص���½����
		UserDao dao = new UserDaoImpl();
		try {
			User u = dao.login(username, pwd);
			List<User> list = dao.findAll();// ��Ѱ�����û�
			// ��ȡsession
			HttpSession session = request.getSession();
			// �û���λ�գ�˵�������û�
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
