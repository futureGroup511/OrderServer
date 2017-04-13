package com.order.dao.impl;

import java.util.Date;

import com.order.dao.DAO;
import com.order.dao.FinanceDAO;
import com.order.domain.Finance;

public class FinanceDAOImp extends DAO<Finance>implements FinanceDAO{

	@Override
	public double getPay(Date date) {
		String sql = "select sum(price*num) from ingredient where buyindate =?";
		return getForValue(sql, date);
	}

	@Override
	public double getInCome(Date date) {
		String sql = "select sum(ordercount) from allorder where orderdate =?";
		return getForValue(sql, date);
	}
}
