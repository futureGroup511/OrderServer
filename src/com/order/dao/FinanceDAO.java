package com.order.dao;

import java.util.Date;

public interface FinanceDAO {
	
	//�������ڻ�ȡ���ж�Ӧ���ڵ����ϵ�֧��
	public double getPay(Date date);
	
	//�������ڻ�ȡ���еĶ������ύ
	public double getInCome(Date date);
}
