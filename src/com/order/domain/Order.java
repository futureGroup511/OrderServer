package com.order.domain;

import java.util.Date;

public class Order {
	private int tablenum;
	private double ordercount;
	private Date orderdate;
	private String orderprogress;
	
	public String getOrderprogress() {
		return orderprogress;
	}
	public void setOrderprogress(String orderprogress) {
		this.orderprogress = orderprogress;
	}
	public Order(){
		
	}
	public Order(int tablenum,double count,Date orderdate){
		this.tablenum = tablenum;
		this.ordercount = count;
		this.orderdate = orderdate;
	}
	
	public double getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(double ordercount) {
		this.ordercount = ordercount;
	}
	
	public int getTablenum() {
		return tablenum;
	}
	public void setTablenum(int tablenum) {
		this.tablenum = tablenum;
	}
	
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
	public String toJson(){
		return String.format("{\"tablenum\":%s,\"ordercount\":%s,\"orderdate\":\"%s\",\"orderprogress\":\"%s\"}",this.tablenum,this.ordercount,this.orderdate,this.orderprogress);
	}
	
	
}
