package com.order.test;

import org.junit.Test;

import com.order.dao.CookDAO;
import com.order.dao.impl.CookDAOImp;
import com.order.domain.cook.Cook;

public class CookTest {
	
	@Test
	public void testGetCook(){
		CookDAO cookDAO = new CookDAOImp();
		Cook cook = cookDAO.getCook("1111", "1111");
		System.out.println(cook.getPhone());
	}
}
