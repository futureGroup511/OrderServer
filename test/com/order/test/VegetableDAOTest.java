package com.order.test;

import java.util.List;

import org.junit.Test;

import com.order.dao.AlllInfoVegetableDAO;
import com.order.dao.VegetableDAO;
import com.order.dao.impl.VegetableDAOImp;
import com.order.dao.impl.VsAllInfoDaoImp;
import com.order.dao.impl.WinDAOImp;
import com.order.domain.AlllInfoVegetable;
import com.order.domain.BaseGoodsInfo;

public class VegetableDAOTest {
	
	@Test
	public void saveTest(){
		VegetableDAO vegetableDAO = new WinDAOImp();
		AlllInfoVegetable alllInfoVegetable = new AlllInfoVegetable("煎饼果子","它是一个非常好吃的东西","20","jinabingguozi.jpg");
		vegetableDAO.save(alllInfoVegetable);
	} 
	@Test
	public void getAllTest(){
		VegetableDAO vegetableDAO = new VegetableDAOImp();
		List<BaseGoodsInfo> list = vegetableDAO.getAll();
		//System.out.println(list);
	}
	@Test
	public void deleteTest(){
		VegetableDAO vegetableDAO = new VegetableDAOImp();
		vegetableDAO.delete("煎饼果子");
	}
	
	@Test
	public void getTest(){
		VegetableDAO vegetableDAO = new VegetableDAOImp();
		BaseGoodsInfo baseGoodsInfo = vegetableDAO.get("葱爆羊肉");
		System.out.println(baseGoodsInfo);
	}
	
	@Test
	public void getallinfo(){
		AlllInfoVegetableDAO alllInfoVegetableDAO = new VsAllInfoDaoImp();
		List<AlllInfoVegetable> list = alllInfoVegetableDAO.getAllwin();
		for(AlllInfoVegetable all:list){
			System.out.println(all.getGoodsname());
		}
	}
}
