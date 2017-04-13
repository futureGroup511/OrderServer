package com.order.dao;

import java.util.List;

import com.order.domain.client.AlreadyGoods;

public interface AlreadyGoodsDAO {
	
	//添加提交的订单中的货物
	public void saveAlready(AlreadyGoods alreadyGoods);
	
	public List<AlreadyGoods> getAll();
}
