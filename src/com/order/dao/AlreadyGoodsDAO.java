package com.order.dao;

import java.util.List;

import com.order.domain.client.AlreadyGoods;

public interface AlreadyGoodsDAO {
	
	//����ύ�Ķ����еĻ���
	public void saveAlready(AlreadyGoods alreadyGoods);
	
	public List<AlreadyGoods> getAll();
}
