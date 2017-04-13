package com.order.test;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.order.dao.OrderDAO;
import com.order.dao.impl.OrderDAOImp;
import com.order.domain.Order;

public class OrderDAOTest {
	
	@Test
	public void save(){
		OrderDAO orderDAO = new OrderDAOImp();
		Order order = new Order(49,677,new Date());
		orderDAO.save(order);
	}
	@Test
	public void getAll(){
		OrderDAO orderDAO = new OrderDAOImp();
		List<Order> list = orderDAO.getAll();
		for(Order order:list){
			System.out.println(order.getOrdercount()+"***"+order.getOrderprogress());
		}
	}
	
	@Test
	public void delete(){
		OrderDAO orderDAO = new OrderDAOImp();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = simpleDateFormat.parse("2016-09-16");
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		orderDAO.delete(45, date);
	}
	
	@Test
	public void update(){
		OrderDAO orderDAO = new OrderDAOImp();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	}
	@Test
	public void getprogress(){
		Date date;
		String strdate ="2016-09-27 19:16:35";	//客户端传过来的精确到秒的时间
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ParsePosition pos = new ParsePosition(0);
		date = formatter.parse(strdate, pos);
		
		OrderDAO orderDAO = new OrderDAOImp();
		String  orderprogress = orderDAO.getpro(12, date);
		System.out.println(orderprogress+"******获取的进度******");
	}
}
