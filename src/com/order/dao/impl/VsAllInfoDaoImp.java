package com.order.dao.impl;

import java.util.List;

import com.order.dao.AlllInfoVegetableDAO;
import com.order.dao.DAO;
import com.order.domain.AlllInfoVegetable;

public class VsAllInfoDaoImp extends DAO<AlllInfoVegetable> implements AlllInfoVegetableDAO{

	@Override
	public List<AlllInfoVegetable> getall() {
		String sql="select * from table_vs";
		return getForList(sql);
	}

	@Override
	public List<AlllInfoVegetable> getAllwin() {
		String sql="select * from table_win";
		return getForList(sql);
	}
	
}
