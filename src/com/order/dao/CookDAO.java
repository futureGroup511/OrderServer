package com.order.dao;

import com.order.domain.cook.Cook;

public interface CookDAO {
	
	public Cook getCook(String name,String password);
	
	public Cook getCookByName(String name);
	
	public void saveCook(String name,String password);
	
	
}
