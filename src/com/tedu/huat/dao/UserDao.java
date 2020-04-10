package com.tedu.huat.dao;

import java.util.List;

import com.tedu.huat.pojo.User;

/**
 * data access object
 * �û������ݷ��ʶ���
 * @author ����
 *
 */
public interface UserDao {
	//�ж��û������Ƿ�ע��
	User findByName(String username)throws Exception;//���׳�������
	//ע���û�
	boolean save(User u) throws Exception;
	//��½
	public User login(String username, String pwd)throws Exception;
	//��ѯ��ǰ���ݿ��е�����Ԫ��
	public List<User> findAll() throws Exception;
	
	
}
