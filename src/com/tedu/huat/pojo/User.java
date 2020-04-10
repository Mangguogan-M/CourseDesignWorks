package com.tedu.huat.pojo;

import java.io.Serializable;

public class User implements Serializable {
	// ����
	private Integer id;
	// �û���
	private String username;
	// ����
	private String pwd;
	// �ǳ�
	private String nickname;
	// �Ա�
	private char gendar;
	// ����
	private Integer age;
	// �绰
	private String phone;

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", pwd=" + pwd + ", nickname=" + nickname + ", gendar="
				+ gendar + ", age=" + age + ", phone=" + phone + "]";
	}

	public User() {
		super();
	}

	public User(String username, String pwd, String nickname, char gendar, Integer age, String phone) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.nickname = nickname;
		this.gendar = gendar;
		this.age = age;
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public char getGendar() {
		return gendar;
	}

	public void setGendar(char gendar) {
		this.gendar = gendar;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
