package com.haifeng.data;

public class Patient {
	private Object pid;
	private String name;
	private char sex;
	private Object age;
	private String nation;
	private String sid;
	private Object wid;
	private String pdate;
	public Object getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public String getNation() {
		return nation;
	}
	public String getPdate() {
		return pdate;
	}
	public Object getPid() {
		return pid;
	}
	public char getSex() {
		return sex;
	}
	public String getSid() {
		return sid;
	}
	public Object getWid() {
		return wid;
	}
	public void setAge(Object age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public void setPdate(String pdate) {
		this.pdate = pdate;
	}
	public void setPid(Object pid) {
		this.pid = pid;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public void setWid(Object wid) {
		this.wid = wid;
	}

}
