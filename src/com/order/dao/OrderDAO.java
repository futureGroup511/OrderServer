package com.order.dao;

import java.util.Date;
import java.util.List;

import com.oder.domain.service.BaseGoodsInfos;
import com.order.domain.Order;

public interface OrderDAO {
	
		//�ṩ�����Ϣ�ķ���
		public boolean save(Order order);
		
		
		//��ȡ���ݿ������еĶ�������Ϣ(��Ϣ�в�����·��)
		public List<Order> getAll();
		//��ȡ���ݿ������еĶ�������Ϣ(��Ϣ�в�����·��)
		public List<Order> getAllOfNum(int num);
		//��ȡ���ݿ������еĶ�������Ϣ(��Ϣ�в�����·��)
		public List<Order> getNotReceiveOrder ();
		
		//���δ��ɶ���
		List<Order> getNoFinish();
		
		//���δ��ɶ���
		List<Order> getNoFinish(int tablenum);
		
		public List<Order> getAll(int tablenum);
				
		//���ݲ���ɾ������
		public void delete(int tablenum,Date orderdate);
		
		//�޸Ķ�����Ϣ�ķ���
		public void update(int tablenum,Date olddate,Date newdate,double count);
		
		//���������޸���Ӧ�Ķ����Ľ���
		public void update(int tablenum,String progress);
		//���ݲ������ص���ʵ�������Ϣ�Թ��޸�
		public Order get(int tablenum,Date orderdate);
		
		
		//�������ź����ڷ��ض�Ӧ�Ĳ˵Ľ���
		public String getpro(int tablenum,Date orderdate);


		List<Order> getPage(int pageNo, int pageSize);
 
		List<Order> getPageByDate(int pageNo, int pageSize,Date start,Date end);	

}
