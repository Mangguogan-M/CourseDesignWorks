package com.tedu.huat.web;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;


import com.tedu.huat.util.VerifyCodeUtil;

/**
 * ��֤servelet
 * @author ����
 */
@WebServlet("/verify")
public class VerifyServlet extends HttpServlet{
	//������֤��ĵ�����д����ҵ��
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//��hi��������ΪͼƬ����
		response.setContentType("image/jpeg");
		//�����޻���
		response.setHeader("Pragma", "No-cache");
		//�õ����ǵ���֤��
		Map<String, BufferedImage> map = VerifyCodeUtil.getMap();
		//�õ�ͼƬ
		BufferedImage image = VerifyCodeUtil.getImg(map);
		//�õ�����
		String code = VerifyCodeUtil.getCode(map);
		//ͨ��session���а�
		HttpSession session = request.getSession();
		session.setAttribute("code2", code);
		
		//ͨ��������д��ͼƬ������Ҫѹ��ͼƬ
		OutputStream os = response.getOutputStream();
		//ѹ��ͼƬ
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
//		encoder.encode(image);
//		ImageIO.write(image, "iamge", os);//�ȽϹ��ϵ�
		
		
		//response.getWriter().println("Hello world! My Frist Servlet!");
	}
	
	
}
