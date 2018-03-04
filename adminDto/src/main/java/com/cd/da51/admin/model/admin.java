package com.cd.da51.admin.model;

import java.io.Serializable;

public class admin implements Serializable {

	private long id;//admin账号的id，
	private String name;
	private String create_tiem;
	private String ten;
	private char sex;
	private  int level;
	private int pray;//前线
	private String cont;
	private String province;
	private  String city;
	private String lateDate;
	
	
	public String getLateDate() {
		return lateDate;
	}
	public void setLateDate(String lateDate) {
		this.lateDate = lateDate;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreate_tiem() {
		return create_tiem;
	}
	public void setCreate_tiem(String create_tiem) {
		this.create_tiem = create_tiem;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPray() {
		return pray;
	}
	public void setPray(int pray) {
		this.pray = pray;
	}
	
	
}
