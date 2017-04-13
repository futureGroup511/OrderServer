package com.order.dao.impl;

import com.order.dao.CookDAO;
import com.order.dao.DAO;
import com.order.domain.cook.Cook;

public class CookDAOImp extends DAO<Cook> implements CookDAO{
	
	//根据用户名和方法从数据库中获取相应的用户信息
	@Override
	public Cook getCook(String phone, String password) {
		String sql="select * from cook where phone=? and password=?";
		return get(sql, phone,password);
	}
	
	//根据用户名查看是否数据中有相应的信息，据此提供给注册时是否有已经存在的用户
	@Override
	public Cook getCookByName(String name) {
		String sql ="select * from cook where phone = ?";
		return get(sql, name);
	}
	
	//根据用户名和密码注册相应的信息
	@Override
	public void saveCook(String name, String password) {
		String sql = "insert into cook (phone,password) values(?,?)";
		update(sql, name,password);
	}
	
}
