package com.order.domain;

public class VsInRelative {
	

	private String vsname;
	private String ingrename;
	private int num;
	
	public VsInRelative(){
		
	}
	public VsInRelative(String vsname,String ingrename,int num){
		this.vsname = vsname;
		this.ingrename = ingrename;
		this.num = num;
	}
	public String getVsname() {
		return vsname;
	}
	public void setVsname(String vsname) {
		this.vsname = vsname;
	}

	@Override
	public String toString() {
		return "VsInRelative [vsname=" + vsname + ", ingrename=" + ingrename + ", num=" + num + "]";
	}
	public String getIngrename() {
		return ingrename;
	}
	public void setIngrename(String ingrename) {
		this.ingrename = ingrename;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
