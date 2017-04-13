package com.order.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.order.dao.FinanceDAO;
import com.order.dao.impl.FinanceDAOImp;

public class FinanceAction extends SuperAction {

	
	private static final long serialVersionUID = 1L;
	
	public String reflectfinance(){
		
		return "reflectfinance";
	}
	
	
	public String getFinance(){
		Date date = null;
		String strdate = reques.getParameter("date");
		FinanceDAO financeDAO = new FinanceDAOImp();
		try {
			date = parseDate(strdate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double pay = financeDAO.getPay(date);
		double income = financeDAO.getInCome(date);
		double profit = income-pay;
		reques.setAttribute("pay", pay);
		reques.setAttribute("income", income);
		reques.setAttribute("profit", profit);
		return "queryfin_success";
	}
	
	public Date parseDate(String strdate) throws ParseException{
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		date = simpleDateFormat.parse(strdate);	
		return date;
	}
}
