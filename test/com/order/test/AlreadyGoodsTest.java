package com.order.test;

import java.util.List;

import org.junit.Test;

import com.order.dao.AlreadyGoodsDAO;
import com.order.dao.impl.AlreadyGoodsDAOImp;
import com.order.domain.client.AlreadyGoods;

public class AlreadyGoodsTest {

	@Test
	public void testGetAll(){
		AlreadyGoodsDAO alreadyGoodsDAO = new AlreadyGoodsDAOImp();
		List<AlreadyGoods> list = alreadyGoodsDAO.getAll();
		for(AlreadyGoods alreadyGoods:list){
			System.out.println(alreadyGoods.getGoodsname());
		}
	}
}
