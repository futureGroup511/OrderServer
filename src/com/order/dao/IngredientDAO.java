package com.order.dao;

import java.util.List;

import com.order.domain.Ingredient;
import com.order.domain.User;


public interface IngredientDAO{
	
	//提供添加信息的方法
		public void save(Ingredient ingredient);
		
		//获取数据库中所有的菜的信息(信息中不包含路径)
		public List<Ingredient> getAll();
		
		public List<Ingredient> getAll(String goodsname);
		
		//根据菜名删除菜
		public void delete(String name);
		
		//根据菜名修改信息
		public void update(Ingredient vegetable);
		
		//根据菜名返回单个实体类的信息以供修改或者单个的查询
		public Ingredient get(String name);

		List<Ingredient> getPage(int pageNo, int pageSize);
		 
}
