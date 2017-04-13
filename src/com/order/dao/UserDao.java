package com.order.dao;

import java.util.List;

import com.order.domain.User;

public interface UserDao {
	
	//注册的方法
	public void save(User user);		
	
	//登录的方法
	public User getUser(String phone,String password);	 
	
	//根据phone的查询对应的用户判断其是否存在的方法
	public User get(String phone);
	
	//
	/*public List<User>  getPage(String phone,int pageNo,int pageSize);*/
	
	
	
}
