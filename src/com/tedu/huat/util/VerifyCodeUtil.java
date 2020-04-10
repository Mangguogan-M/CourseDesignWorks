package com.tedu.huat.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Map.Entry;

/**
 * 验证码工具类
 * @author 马坤
 */
public class VerifyCodeUtil {
	// 验证码创建方法 返回Map<数字， 图片>
	public static Map<String, BufferedImage> getMap() {
		// 新建一张bufferedimage图片
		BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		// 得到画笔对象 来画图
		Graphics g = image.getGraphics();
		// 设置画笔的颜色
		g.setColor(Color.white);
		// 给这个图片填充背景
		// 0,0坐标坐标原点，后面的是填充大小
		g.fillRect(0, 0, 100, 50);
		// 给这个100*50 图片绘制一个黑色的边框
		g.setColor(Color.red);
		// 画一个边框
		g.drawRect(0, 0, 99, 49);
		// 购机一个map保存数字和图片
		Map<String, BufferedImage> map = new HashMap<>();
		StringBuilder str = new StringBuilder(); // 变长字符串
		// 随机字符，随机颜色
		Random r = new Random();
		for (int i = 0; i < 4; i++) {// 54-91 A-Z 汉字
			// 汉字
			char ch2 = (char) ('\u4e00' + r.nextInt('\u9fa5' - '\u4e00'));
			char ch = (char) (65 + r.nextInt(26));
			// 颜色随机
			Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			g.setColor(c);// 把颜色帮定到画笔上
			// 添加一个字体
			Font f = new Font("隶书", Font.BOLD, 30);
			g.setFont(f);
			// 画线（两个点）
			g.drawLine(r.nextInt(49), r.nextInt(69), r.nextInt(99), r.nextInt(49));

			g.drawString(ch + "", 8 + 23 * i, 35);
			// 将字符放到字符串中
			str.append(ch);
		}
		map.put(str.toString(), image);
		return map;
	}

	// 封装一个迭代数字的方法
	public static String getCode(Map<String, BufferedImage> map) {
		// 先得到map的集合entryset
		Set<Entry<String, BufferedImage>> set = map.entrySet();
		// 2、得到迭代器
		Iterator<Entry<String, BufferedImage>> it = set.iterator();
		// 迭代
		Entry<String, BufferedImage> entry = it.next();
		return entry.getKey();
	}

	// 封装一个迭代图片的方法
	public static BufferedImage getImg(Map<String, BufferedImage> map) {
		// 先得到map的集合entryset
		Set<Entry<String, BufferedImage>> set = map.entrySet();
		// 2、得到迭代器
		Iterator<Entry<String, BufferedImage>> it = set.iterator();
		// 迭代
		Entry<String, BufferedImage> entry = it.next();
		return entry.getValue();
	}
}
