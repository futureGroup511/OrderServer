package com.order.dao.impl;

import com.order.dao.CustomerDao;
import com.order.dao.DAO;
import com.order.domain.Customer;

public class CustomerDaoImp extends DAO<Customer> implements CustomerDao {

	@Override
	public Customer login(String username, String password) {
		System.out.println(username+password);
		// TODO Auto-generated method stub
		if(null == username || null ==password ){
			return null;
		}
		if("".equals(username) || "".equals(password)){
			return null;
		}
		Customer customer = get("select * from tb_customer where username=? and password = ?", username,password);
		return customer;
	}

	@Override
	public boolean change(String username, String password) {
		// TODO Auto-generated method stub
		if(null == username || null ==password ){
			return false;
		}
		if("".equals(username) || "".equals(password)){
			return false;
		}
		if(null == get("select * from tb_customer where username=?", username)){
			return false;
		}
		String sql = "update tb_customer set password = ? where username = ?";
		update(sql, password,username);
		return true;
	}

}
