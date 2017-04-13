package com.order.domain.client;

import java.util.Date;

public class FindSource {
	//���ϵ�����
	private String goodsname;
	//���ϵĹ���Դ
	private String goodssource;
	//���ϵĹ�������
	private Date buyindate;
	//���ϵĵ���
	private double price;
	//����ĳһ�ֲ���Ҫ���ϵ�����
	private int num;
	public FindSource(){
		
	}
	
	
	public FindSource(String goodsname, String goodssource, Date buyindate, double price, int num) {
		this.goodsname = goodsname;
		this.goodssource = goodssource;
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
