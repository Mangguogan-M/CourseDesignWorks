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
 * ��֤�빤����
 * @author ����
 */
public class VerifyCodeUtil {
	// ��֤�봴������ ����Map<���֣� ͼƬ>
	public static Map<String, BufferedImage> getMap() {
		// �½�һ��bufferedimageͼƬ
		BufferedImage image = new BufferedImage(100, 50, BufferedImage.TYPE_3BYTE_BGR);
		// �õ����ʶ��� ����ͼ
		Graphics g = image.getGraphics();
		// ���û��ʵ���ɫ
		g.setColor(Color.white);
		// �����ͼƬ��䱳��
		// 0,0��������ԭ�㣬�����������С
		g.fillRect(0, 0, 100, 50);
		// �����100*50 ͼƬ����һ����ɫ�ı߿�
		g.setColor(Color.red);
		// ��һ���߿�
		g.drawRect(0, 0, 99, 49);
		// ����һ��map�������ֺ�ͼƬ
		Map<String, BufferedImage> map = new HashMap<>();
		StringBuilder str = new StringBuilder(); // �䳤�ַ���
		// ����ַ��������ɫ
		Random r = new Random();
		for (int i = 0; i < 4; i++) {// 54-91 A-Z ����
			// ����
			char ch2 = (char) ('\u4e00' + r.nextInt('\u9fa5' - '\u4e00'));
			char ch = (char) (65 + r.nextInt(26));
			// ��ɫ���
			Color c = new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
			g.setColor(c);// ����ɫ�ﶨ��������
			// ���һ������
			Font f = new Font("����", Font.BOLD, 30);
			g.setFont(f);
			// ���ߣ������㣩
			g.drawLine(r.nextInt(49), r.nextInt(69), r.nextInt(99), r.nextInt(49));

			g.drawString(ch + "", 8 + 23 * i, 35);
			// ���ַ��ŵ��ַ�����
			str.append(ch);
		}
		map.put(str.toString(), image);
		return map;
	}

	// ��װһ���������ֵķ���
	public static String getCode(Map<String, BufferedImage> map) {
		// �ȵõ�map�ļ���entryset
		Set<Entry<String, BufferedImage>> set = map.entrySet();
		// 2���õ�������
		Iterator<Entry<String, BufferedImage>> it = set.iterator();
		// ����
		Entry<String, BufferedImage> entry = it.next();
		return entry.getKey();
	}

	// ��װһ������ͼƬ�ķ���
	public static BufferedImage getImg(Map<String, BufferedImage> map) {
		// �ȵõ�map�ļ���entryset
		Set<Entry<String, BufferedImage>> set = map.entrySet();
		// 2���õ�������
		Iterator<Entry<String, BufferedImage>> it = set.iterator();
		// ����
		Entry<String, BufferedImage> entry = it.next();
		return entry.getValue();
	}
}
