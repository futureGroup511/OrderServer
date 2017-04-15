package com.order.dao;

import java.util.Date;
import java.util.List;

import com.oder.domain.service.BaseGoodsInfos;
import com.order.domain.Order;

public interface OrderDAO {
	
		//提供添加信息的方法
		public void save(Order order);
		
		
		//获取数据库中所有的订单的信息(信息中不包含路径)
		public List<Order> getAll();
		//获取数据库中所有的订单的信息(信息中不包含路径)
		public List<Order> getNotReceiveOrder (String pro);
		
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


 
		
}
