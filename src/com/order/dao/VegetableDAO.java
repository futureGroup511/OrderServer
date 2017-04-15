package com.order.dao;

import java.util.List;

import com.oder.domain.service.BaseGoodsInfos;
import com.order.domain.AlllInfoVegetable;
import com.order.domain.BaseGoodsInfo;
import com.order.domain.User;

public interface VegetableDAO {
	
	//�ṩ�����Ϣ�ķ���
	public void save(AlllInfoVegetable vegetable);
	
	//��ȡ���ݿ������еĲ˵���Ϣ(��Ϣ�в�����·��)
	public List<BaseGoodsInfo> getAll();
		
	public List<BaseGoodsInfo> getAll(String name);
	//���ݲ���ɾ����
	public void delete(String name);
	
	//���ݲ����޸���Ϣ
	public void update(BaseGoodsInfo vegetable);
	
	//���ݲ������ص���ʵ�������Ϣ�Թ��޸�
	public BaseGoodsInfo get(String name);
	public List<BaseGoodsInfos>  getPage(int pageNo,int pageSize);
}
