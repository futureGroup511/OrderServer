package com.order.domain;

public class AlllInfoVegetable extends BaseGoodsInfo{
	private String path;
	
	public AlllInfoVegetable(){
		
	}
	public AlllInfoVegetable(String goodsname,String goodsdesc,String price,String path){
		super(goodsname,goodsdesc,price);
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
}
