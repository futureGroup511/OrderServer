package com.order.dao;

import com.order.domain.Customer;

public interface CustomerDao {
	Customer login(String username,String password);
	boolean change(String username,String password);
}
