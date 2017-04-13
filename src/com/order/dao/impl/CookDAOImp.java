package com.order.dao.impl;

import com.order.dao.CookDAO;
import com.order.dao.DAO;
import com.order.domain.cook.Cook;

public class CookDAOImp extends DAO<Cook> implements CookDAO{
	
	//�����û����ͷ��������ݿ��л�ȡ��Ӧ���û���Ϣ
	@Override
	public Cook getCook(String phone, String password) {
		String sql="select * from cook where phone=? and password=?";
		return get(sql, phone,password);
	}
	
	//�����û����鿴�Ƿ�����������Ӧ����Ϣ���ݴ��ṩ��ע��ʱ�Ƿ����Ѿ����ڵ��û�
	@Override
	public Cook getCookByName(String name) {
		String sql ="select * from cook where phone = ?";
		return get(sql, name);
	}
	
	//�����û���������ע����Ӧ����Ϣ
	@Override
	public void saveCook(String name, String password) {
		String sql = "insert into cook (phone,password) values(?,?)";
		update(sql, name,password);
	}
	
}
