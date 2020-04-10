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
		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// �õ��û�����Ĳ���
		String username = request.getParameter("username");
		String nickname = request.getParameter("nickname");
		String pwd = request.getParameter("pwd");
		Integer age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		char gendar = request.getParameter("gendar").charAt(0);
		// ע���û�
		User u = new User(username, pwd, nickname, gendar, age, phone);
		UserDao dao = new UserDaoImpl();
		try {
			boolean b = dao.save(u);
			if (b) {// ����ɹ�,���û�����ת�������Ժ��Զ���תҳ��
				request.setAttribute("name", nickname);
				request.getRequestDispatcher("success_1.jsp").forward(request, response);
			}
		} catch (Exception e) {// ����ʧ�ܣ�һ�㶼��������תע��ҳ��
			e.printStackTrace();
			response.getWriter().println("����ʧ�ܣ�<a href = 'myregist.html'>�������ע��</a>");
		}
	}

}
