package com.order.domain.client;

public class AlreadyGoods {
	
	//�Ѿ��ύ�Ĳ˵��еĲ˺��߾Ƶ�����
	private String goodsname;
	//�û�������ڵ����ӵĺ���
	private int tablenum;
	//ÿ���˻��߾Ƶ�����
	private int num;
	//��dbutils�ṩһ���յĹ��췽����������
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
	
	public String toJson(){
		return String.format("{\"goodsname\":\"%s\",\"tablenum\":%s,\"num\":%s}",this.goodsname,this.tablenum,this.num);
	}
	
	
}
