package com.order.dao.impl;

import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.order.dao.DAO;
import com.order.dao.UserDao;
import com.order.domain.User;

public class UserDaoImp extends DAO<User> implements UserDao{

	@Override
	public void save(User user) {
		String sql = "INSERT INTO staff(phone,password) VALUE(?,?)";
		update(sql, user.getPhone(),user.getPassword());
	}
	
	@Override
	public User getUser(String phone, String password) {
		String sql = "select * from staff where phone=? and password=?";
		return get(sql, phone,password);
	}

	@Override
	public User get(String phone) {
		String sql = "select * from staff where phone=?";
		return get(sql, phone);
	}

	/*@Override
	public List<User> getPage(String phone,int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String sql= "select * from staff where phone=?";
		CachedRowSet set=findByPage(sql,phone,pageNo, pageSize);
		
		return null;
	}*/

}
