package com.order.dao;

import java.util.List;

import com.oder.domain.service.BaseGoodsInfos;
import com.order.domain.AlllInfoVegetable;
import com.order.domain.BaseGoodsInfo;
import com.order.domain.User;

public interface VegetableDAO {
	
	//提供添加信息的方法
	public void save(AlllInfoVegetable vegetable);
	
	//获取数据库中所有的菜的信息(信息中不包含路径)
	public List<BaseGoodsInfo> getAll();
	
	public List<BaseGoodsInfo> getAll(String name);
	//根据菜名删除菜
	public void delete(String name);
	
	//根据菜名修改信息
	public void update(BaseGoodsInfo vegetable);
	
	//根据菜名返回单个实体类的信息以供修改
	public BaseGoodsInfo get(String name);
	public List<BaseGoodsInfos>  getPage(int pageNo,int pageSize);
}
