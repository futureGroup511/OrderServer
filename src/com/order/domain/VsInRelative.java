package com.order.domain;

public class VsInRelative {
	
	private String vsname;
	private String inname;
	private int num;
	
	public VsInRelative(){
		
	}
	public VsInRelative(String vsname,String inname,int num){
		this.vsname = vsname;
		this.inname = inname;
		this.num = num;
	}
	public String getVsname() {
		return vsname;
	}
	public void setVsname(String vsname) {
		this.vsname = vsname;
	}
	public String getInname() {
		return inname;
	}
	public void setInname(String inname) {
		this.inname = inname;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
