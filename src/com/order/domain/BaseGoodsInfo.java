package com.order.domain;

public class BaseGoodsInfo {
	
	private   String goodsname;
	private    String goodsdesc;
	private     String price;
	
	public BaseGoodsInfo(String goodsname,String goodsdesc,String price){
		this.goodsname = goodsname;
		this.goodsdesc = goodsdesc;
		this.price = price;
	}
	//在用dbutils的时候返回一个或者多个bean时必须要重写无参数的构造方法，不然无法组装成一个bean
	public BaseGoodsInfo(){
		
	}
	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public String getGoodsdesc() {
		return goodsdesc;
	}
	public void setGoodsdesc(String goodsdesc) {
		this.goodsdesc = goodsdesc;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
