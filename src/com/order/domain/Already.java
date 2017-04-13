package com.order.domain;

public class Already {
	
	private String goodsname;
	private int tablenum;
	private int num;
	
	
	public Already() {
	
	}
	
	public Already(String goodsname, int tablenum, int num) {
		this.goodsname = goodsname;
		this.tablenum = tablenum;
		this.num = num;
	}

	public String getGoodsname() {
		return goodsname;
	}
	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
	public int getTablenum() {
		return tablenum;
	}
	public void setTablenum(int tablenum) {
		this.tablenum = tablenum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
