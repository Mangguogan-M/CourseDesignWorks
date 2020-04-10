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
 *�����û�����ѯ��ǰ�û���servelet
 * Servlet implementation class FindName
 */
@WebServlet("/findName")
public class FindName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//�����������
		request.setCharacterEncoding("utf-8");
		//���÷�����������
		response.setContentType("text/html;charset = utf-8");
		//�õ��û����ݹ�����anme1
		String name = request.getParameter("name1");
		//�������ݿ⣬��ѯ�����Ƿ����
		UserDao dao = new UserDaoImpl();
		try {
			User u = dao.findByName(name);
			if(u == null) {//Ϊ��˵�����û�δ��ע�ᣬ����ʹ��
				response.getWriter().println("true");
			}else {//�û�����˵������ʹ��
				response.getWriter().println("false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
