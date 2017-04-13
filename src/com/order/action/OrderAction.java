package com.order.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.oder.domain.service.BaseGoodsInfos;
import com.order.dao.OrderDAO;
import com.order.dao.impl.OrderDAOImp;
import com.order.domain.Order;

public class OrderAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	OrderDAO orderDAO = new OrderDAOImp();
	private  static int pageNo=1;
	private static int pageSize=8;
	private String strtablenum;
	private String strdatetime;
	private String strordercount;
	private int tablenum;
	private int oldtablenum;
	private double ordercount;
	private Date date;
	private static Date olddate;
	public String page(){
		int number=3;
		 
		String numbers=ServletActionContext.getRequest().getParameter("number");
		if(numbers!=null&&!numbers.equals(""))
		{
			  number=Integer.parseInt(numbers);
			
		}
		
		if(number==1){
			pageNo--;
			if(pageNo<1){
				pageNo=1;
			}
	
		 
		}
		if(number==2){
			pageNo++;
			 
		}
		if(number==3){
			pageNo=1;
		
		}
		System.out.println(pageNo);
		List<Order> list = orderDAO.getPage(pageNo, pageSize);
		reques.setAttribute("allorder", list);
		
		return "queryallorder_success";
		
	}
	public String queryAllOrder(){
		List<Order> list = orderDAO.getAll();
		reques.setAttribute("allorder", list);
		
		return "queryallorder_success";
	}
	
	public String deleteOrder(){
		initParam();
		orderDAO.delete(tablenum, date);
		return "deleteorder_success";
	}
	
	private void initParam() {
		strtablenum = reques.getParameter("tablenum");
		strdatetime = reques.getParameter("datetime");
		strordercount = reques.getParameter("ordercount");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			date = simpleDateFormat.parse(strdatetime);	//锟斤拷玫锟斤拷锟斤拷诓锟斤拷锟轿�16-x-x,锟斤拷锟皆憋拷锟斤拷锟斤拷锟绞ｏ拷锟侥诧拷锟街诧拷锟斤拷转锟斤拷锟斤拷锟斤拷要锟侥革拷式
			System.out.println(date+"******锟斤拷锟斤拷遣锟斤拷锟�***********");
			tablenum = Integer.parseInt(strtablenum);
			ordercount = Double.parseDouble(strordercount);
			//System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String ordermodifyreflect(){
		initParamOld();
//		System.out.println("oldtablenum:"+oldtablenum);
//		System.out.println("olddate**:"+olddate);
		Order order = orderDAO.get(oldtablenum, olddate);
		reques.setAttribute("order", order);
		return "ordermodifyreflect";
	}
	private void initParamOld() {
		
		strtablenum = reques.getParameter("tablenum");
		strdatetime = reques.getParameter("datetime");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			olddate = simpleDateFormat.parse("20"+strdatetime);	
			System.out.println(olddate+"*****************");
			oldtablenum = Integer.parseInt(strtablenum);
			//System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	public String ordermodify(){
		initParam();
//		System.out.println("**************");
//		System.out.println(tablenum);
//		System.out.println(olddate);
//		System.out.println(date);
//		System.out.println(ordercount);
		orderDAO.update(tablenum, olddate, date, ordercount);
		return null;
	}
	
	
	
	
	
}
