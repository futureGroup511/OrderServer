package com.order.domain;

public class User {
	
	private String phone;
	private String password;
	
	//����dbutils����һ��ʵ��ʱ��������д�޲����Ĺ��췽��
	public User(){
		
	}
	public User(String phone,String password){
		this.phone = phone;
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
