package com.order.test.cook;

import org.junit.Test;

import com.order.dao.CookDAO;
import com.order.dao.OrderDAO;
import com.order.dao.impl.CookDAOImp;
import com.order.dao.impl.OrderDAOImp;
import com.order.domain.cook.Cook;

public class TestCook {
	CookDAO cookDAO = new CookDAOImp();
	OrderDAO orderDAO = new OrderDAOImp();
	@Test
	public void testGetCoook(){
		
		Cook cook = cookDAO.getCookByName("18737306083");
		System.out.println("这是根据名字得到的厨师的相关的信息"+cook.getPassword());
	}
	@Test
	public void insertCook(){
		cookDAO.saveCook("1324123423", "adijfidf");
	}
	@Test
	public void testUpdateProgress(){
		orderDAO.update(23, "未做");
	}
}
