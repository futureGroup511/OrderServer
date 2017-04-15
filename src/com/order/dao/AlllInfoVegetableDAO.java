package com.order.dao;

import java.util.List;

import com.order.domain.AlllInfoVegetable;

public interface AlllInfoVegetableDAO {
	
	//返回所有的菜的信息，包括路径的集合
	public List<AlllInfoVegetable> getall();
	
	//返回所有酒的信息
	public List<AlllInfoVegetable> getAllwin();
	
	
	
}
