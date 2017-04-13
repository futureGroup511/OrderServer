package com.order.dao;

import java.util.Date;

public interface FinanceDAO {
	
	//根据日期获取所有对应日期的配料的支出
	public double getPay(Date date);
	
	//根据日期获取所有的订单的提交
	public double getInCome(Date date);
}
