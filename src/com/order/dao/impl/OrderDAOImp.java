package com.order.dao.impl;

import java.io.UnsupportedEncodingException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.order.dao.DAO;
import com.order.dao.OrderDAO;
import com.order.db.JdbcUtils;
import com.order.domain.Order;

public class OrderDAOImp extends DAO<Order> implements OrderDAO{

	@Override
	public void save(Order order) {
		// TODO Auto-generated method stub
		String sql = "insert into allorder(tablenum,ordercount,orderprogress,orderdate) value(?,?,?,?)";
		update(sql, order.getTablenum(),order.getOrdercount(),"δ��",order.getOrderdate());
		
	}
	
	@Override
	public List<Order> getAll() {
		String sql ="select tablenum,ordercount,orderprogress,orderdate from allorder ORDER BY orderdate DESC";
		return getForList(sql);
	}

	@Override
	public void delete(int tablenum, Date orderdate) {
		String sql ="delete from allorder where tablenum=? and orderdate =? ";
		update(sql, tablenum,orderdate);
	}

	@Override 
	public void update(int tablenum,Date olddate,Date newdate,double count){
		String sql ="update allorder set ordercount=?,orderdate=? where tablenum=? and orderdate=?";
		update(sql,count,newdate,tablenum,olddate);
	}

	@Override
	public Order get(int tablenum, Date orderdate) {
		String sql = "select * from allorder where tablenum=? and orderdate=?";
		return get(sql, tablenum,orderdate);
	}

	@Override
	public List<Order> getAll(int tablenum) {
		
		String sql ="select tablenum,ordercount,orderdate from allorder where tablenum =? ORDER BY orderdate DESC ";
		return getForList(sql,tablenum);
	}

	@Override
	public String getpro(int tablenum, Date orderdate) {
		String sql ="select orderprogress from allorder where tablenum=? and orderdate=?";
		return getForValue(sql, tablenum,orderdate);
	}

	@Override
	public void update(int tablenum,String progress) {
		String sql = "update allorder set orderprogress = ?   where tablenum=?";
		update(sql,progress, tablenum);
	}
	
	@Override
	public List<Order> getPage(int pageNo,int pageSize) {
		// TODO Auto-generated method stub
		String sql ="select tablenum,ordercount,orderprogress,orderdate from allorder ";
		CachedRowSet set=findByPage(sql, pageNo, pageSize);
		List<Order> list=new ArrayList<>();
		try {
			while(set.next()){
				Order info=new Order();
				 info.setTablenum(set.getInt(1));
				 info.setOrdercount(set.getDouble(2));
				 info.setOrderprogress(set.getString(3));
				 info.setOrderdate(set.getDate(4));
				 
				 
				list.add(info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Order> getNotReceiveOrder(String pro) {
		String p="";
		try {
			p=new String(pro.getBytes(),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		System.out.println("p"+p);
		String sql ="select * from allorder where orderprogress=?";
		return getForList(sql,p);
	}

	/**
	 * ��ȡ���ݿ�������δ��ɵĲ˵�
	 * @author ������
	 */
	@Override
	public List<Order> getUnfinishedOrder() {
		String q="δ����"; 
		String w="����"; 
		String sql ="select * from allorder where orderprogress=? or orderprogress=?";
		return getForList(sql,q,w);
	}
	
	
	
}
