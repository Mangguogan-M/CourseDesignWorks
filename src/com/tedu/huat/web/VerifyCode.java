package com.tedu.huat.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/code")
public class VerifyCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//����������Ĳ��������ǲ�����ֵ���бȽ�
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//���ñ����ʽ
		request.setCharacterEncoding("utf-8");
		//���÷�����������
		response.setContentType("text/html;charset = utf-8");
		//�õ��û���������code
		String code1 = request.getParameter("code1");
		//�õ�ϵͳ֮ǰ���ɵ�codeֵ
		String code2 = (String)request.getSession().getAttribute("code2");
		//�Ƚ�
		if (code1.equalsIgnoreCase(code2)) {
			response.getWriter().println("true");
		}else {
			response.getWriter().println("false");
		}
	}

}
