package com.haifeng.data;

public class Doctor {
	private int row;
	private Object did;
	private String name;
	private String password;
	private char sex;
	private Object age;
	private String phone;
	private String mail;
	private String address;
	public String getAddress() {
		return address;
	}
	public Object getAge() {
		return age;
	}
	public Object getDid() {
		return did;
	}
	public String getMail() {
		return mail;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public char getSex() {
		return sex;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setAge(Object age) {
		this.age = age;
	}
	public void setDid(Object did) {
		this.did = did;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}

}
