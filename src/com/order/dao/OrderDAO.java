package com.order.dao;

import java.util.Date;
import java.util.List;

import com.order.domain.Order;

public interface OrderDAO {
	
		//提供添加信息的方法
		public boolean save(Order order);
		
		
		//获取数据库中所有的订单的信息(信息中不包含路径)
		public List<Order> getAll();
		//获取数据库中所有的订单的信息(信息中不包含路径)
		public List<Order> getToday();
		//获取数据库中所有的订单的信息(信息中不包含路径)
		public List<Order> getNotReceiveOrder ();

		public List<Order> getNotReceiveOrder (String pro);
		//获取数据库中未完成的订单的信息
		public List<Order> getUnfinishedOrder(); 

		public List<Order> getAllOfNum(int num);

		
		//获得未完成订单
		List<Order> getNoFinish();
		
		//获得未完成订单
		List<Order> getNoFinish(int tablenum);
		
		public List<Order> getAll(int tablenum);
				
		//根据菜名删除订单
		public void delete(int tablenum,Date orderdate);
		
		//修改订单信息的方法
		public void update(int tablenum,Date olddate,Date newdate,double count);
		
		//根据桌号修改相应的订单的进度
		public void update(int tablenum,String progress);
		//根据菜名返回单个实体类的信息以供修改
		public Order get(int tablenum,Date orderdate);
		
		
		//根据桌号和日期返回对应的菜的进度
		public String getpro(int tablenum,Date orderdate);


		List<Order> getPage(int pageNo, int pageSize);
 
		List<Order> getPageByDate(int pageNo, int pageSize,String start,String end);	

}
