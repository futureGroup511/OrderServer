package com.order.domain;

import java.util.Date;

public class Ingredient {
	
	private String goodsname;
	private String goodssource;
	private Date buyindate;
	private double price;
	private int num;
	
	public Ingredient(){
		
	}
	public Ingredient(String goodsname,String goodssouce,Date buyindate,double price,int num){
		this.goodsname = goodsname;
		this.goodssource = goodssouce;
		this.buyindate = buyindate;
		this.price = price;
		this.num = num;
	}
	
	
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodssource() {
		return goodssource;
	}
	public void setGoodssource(String goodssource) {
		this.goodssource = goodssource;
	}
	public Date getBuyindate() {
		return buyindate;
	}
	public void setBuyindate(Date buyindate) {
		this.buyindate = buyindate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
