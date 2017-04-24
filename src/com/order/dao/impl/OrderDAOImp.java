package com.order.dao.impl;


import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.mysql.jdbc.PreparedStatement;
import com.order.dao.DAO;
import com.order.dao.OrderDAO;
import com.order.db.JdbcUtils;
import com.order.domain.Order;

public class OrderDAOImp extends DAO<Order> implements OrderDAO{

	@Override
	public boolean save(Order order) {
		// TODO Auto-generated method stub
		String sql1 = String.format("select * from allorder where orderprogress != '付款' and tablenum = %s",order.getTablenum());
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
				return update(sql, order.getTablenum(),order.getOrdercount(),"未接收",new Timestamp(new Date().getTime()));
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
		String a="付款";
		String sql ="select tablenum,ordercount,orderprogress,orderdate from allorder where orderprogress !=? ORDER BY orderdate DESC";
		return getForList(sql,a);
	}
	
	@Override
	public List<Order> getAllOfNum(int num) {
		String sql ="select tablenum,ordercount,orderprogress,orderdate from allorder ORDER BY orderdate DESC limit "+num;
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
	 * 获取数据库中所有未完成的菜单
	 * @author 丁赵雷
	 */
	@Override
	public List<Order> getUnfinishedOrder() {
		String q="未接收"; 
		String w="接收"; 
		String v="付款";
		String sql ="select * from allorder where orderprogress=? or orderprogress=? ";
		return getForList(sql,q,w);
	}
	public List<Order> getNoFinish() {
		// TODO Auto-generated method stub
		String sql = "select * from allorder where orderprogress != '付款'";
		return this.getForList(sql);
	}

	@Override
	public List<Order> getNoFinish(int tablenum) {
		// TODO Auto-generated method stub
		String sql = "select * from allorder where tablenum = ?";
		return this.getForList(sql,tablenum);
	}

	@Override
	public List<Order> getToday() {
		// TODO Auto-generated method stub
		//String sql ="select * from allorder where DATE_FORMAT(FROM_UNIXTIME(orderdate),'%Y-%m-%d')= DATE_FORMAT(NOW(),'%Y-%m-%d')";
		String sql ="select * from allorder where date(orderdate) = curdate()";
		return getForList(sql);
	}
	@Override
	public List<Order> getPageByDate(int pageNo, int pageSize, String start, String end) {
		/*select * from order where timestamp between  UNIX_TIMESTAMP('2013-05-01 00:00:00') and UNIX_TIMESTAMP('2013-05-10 00:00:00');*/
		/*select top 10* from表名 where 主键not in (select top 20 表名 from 主键);--查询显示21-30条记录（10条）*/
		
		String sql ="select tablenum,ordercount,orderprogress,orderdate from allorder where orderdate between  '"+start+"' and '"+end+"' ";
		
		List<Order> list=new ArrayList<>();
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/order?useUnicode=true&amp;characterEncoding=utf8",
					"root","root");
			PreparedStatement ps=(PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()){
				Order od=new Order();
				od.setTablenum(rs.getInt("tablenum"));
				od.setOrdercount(rs.getDouble("ordercount"));
				od.setOrderdate(rs.getDate("orderdate"));
				od.setOrderprogress(rs.getString("orderprogress"));
				list.add(od);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(pageNo==0 && pageSize==0){
			return list;
		}
		else if(pageNo*pageSize%8==0 && pageNo*pageSize<list.size()){
			list=list.subList((pageNo-1)*pageSize, pageNo*pageSize);
		}
		else{
			list=list.subList((pageNo-1)*pageSize,list.size());
		}
		System.out.println(list);
		
		return list;
	}

	@Override
	public List<Order> getNotReceiveOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
