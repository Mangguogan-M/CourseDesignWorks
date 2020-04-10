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
 * 验证servelet
 * @author 马坤
 */
@WebServlet("/verify")
public class VerifyServlet extends HttpServlet{
	//处理验证马的迭代及写出的业务
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//设hi返回类型为图片类型
		response.setContentType("image/jpeg");
		//设置无缓存
		response.setHeader("Pragma", "No-cache");
		//得到我们的验证码
		Map<String, BufferedImage> map = VerifyCodeUtil.getMap();
		//得到图片
		BufferedImage image = VerifyCodeUtil.getImg(map);
		//得到数字
		String code = VerifyCodeUtil.getCode(map);
		//通过session进行绑定
		HttpSession session = request.getSession();
		session.setAttribute("code2", code);
		
		//通过输入流写入图片对象，需要压缩图片
		OutputStream os = response.getOutputStream();
		//压缩图片
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
//		encoder.encode(image);
//		ImageIO.write(image, "iamge", os);//比较古老的
		
		
		//response.getWriter().println("Hello world! My Frist Servlet!");
	}
	
	
}
