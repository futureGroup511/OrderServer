package com.order.domain.client;

public class AlreadyGoods {
	
	//已经提交的菜单中的菜后者酒的名字
	private String goodsname;
	//用户点餐所在的桌子的号码
	private int tablenum;
	//每个菜或者酒的数量
	private int num;
	//给dbutils提供一个空的构造方法用来反射
	public AlreadyGoods(){
		
	}
	public AlreadyGoods(String goodsname, int tablenum, int num) {
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
