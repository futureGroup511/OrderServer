package com.order.dao;

import java.util.List;

import com.order.domain.client.AlreadyGoods;

public interface AlreadyGoodsDAO {
	
	//添加提交的订单中的货物
	public void saveAlready(AlreadyGoods alreadyGoods);
	
	public List<AlreadyGoods> getAll();
	
	//按桌子返回
	public List<AlreadyGoods> getByTablenum(int n);
	
	//按桌子删除
	public boolean deleteAll(int tablenum);
}
