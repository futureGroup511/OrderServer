package com.order.dao;

import java.util.List;

import com.order.domain.User;

public interface UserDao {
	
	//ע��ķ���
	public void save(User user);		
	
	//��¼�ķ���
	public User getUser(String phone,String password);	 
	
	//����phone�Ĳ�ѯ��Ӧ���û��ж����Ƿ���ڵķ���
	public User get(String phone);
	
	//
	/*public List<User>  getPage(String phone,int pageNo,int pageSize);*/
	
	
	
}
