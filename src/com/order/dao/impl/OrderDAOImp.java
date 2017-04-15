package com.order.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.order.dao.DAO;
import com.order.dao.OrderDAO;
import com.order.db.JdbcUtils;
import com.order.domain.Order;

public class OrderDAOImp extends DAO<Order> implements OrderDAO{

	//ï¿½Ð¶Ïµï¿½Ç°ï¿½ï¿½ï¿½ï¿½ï¿½Ç·ï¿½ï¿½ï¿½
	@Override
	public boolean save(Order order) {
		// TODO Auto-generated method stub
		String sql1 = String.format("select * from allorder where orderprogress != '¸¶¿î' and tablenum = %s",order.getTablenum());
		Connection conn=null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtils.getConnection();
			st=conn.createStatement();
			rs=st.executeQuery(sql1);
			if(rs.next()){
				return false;
			}else{
				String sql = "insert into allorder(tablenum,ordercount,orderprogress,orderdate) value(?,?,?,?)";
				return update(sql, order.getTablenum(),order.getOrdercount(),"Î´½ÓÊÕ",new Timestamp(new Date().getTime()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JdbcUtils.releaseConnection(conn);
		}
		return false;
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
	public List<Order> getNoFinish() {
		// TODO Auto-generated method stub
		String sql = "select * from allorder where orderprogress != '¸¶¿î'";
		return this.getForList(sql);
	}

	@Override
	public List<Order> getNoFinish(int tablenum) {
		// TODO Auto-generated method stub
		String sql = String.format("select * from allorder where orderprogress != '¸¶¿î' and tablenum = %s",tablenum);
		return this.getForList(sql);
	}
	public List<Order> getNotReceiveOrder() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
