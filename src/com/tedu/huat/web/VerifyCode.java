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
	//将请求过来的参数和我们产生的值进行比较
	protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		//设置编码格式
		request.setCharacterEncoding("utf-8");
		//设置返回数据类型
		response.setContentType("text/html;charset = utf-8");
		//得到用户传过来的code
		String code1 = request.getParameter("code1");
		//得到系统之前生成的code值
		String code2 = (String)request.getSession().getAttribute("code2");
		//比较
		if (code1.equalsIgnoreCase(code2)) {
			response.getWriter().println("true");
		}else {
			response.getWriter().println("false");
		}
	}

}
