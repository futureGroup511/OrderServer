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
	//����dbutils��ʱ�򷵻�һ�����߶��beanʱ����Ҫ��д�޲����Ĺ��췽������Ȼ�޷���װ��һ��bean
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
