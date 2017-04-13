package com.order.dao;

import java.util.List;

import com.order.domain.Ingredient;
import com.order.domain.User;


public interface IngredientDAO{
	
	//�ṩ�����Ϣ�ķ���
		public void save(Ingredient ingredient);
		
		//��ȡ���ݿ������еĲ˵���Ϣ(��Ϣ�в�����·��)
		public List<Ingredient> getAll();
		
		public List<Ingredient> getAll(String goodsname);
		
		//���ݲ���ɾ����
		public void delete(String name);
		
		//���ݲ����޸���Ϣ
		public void update(Ingredient vegetable);
		
		//���ݲ������ص���ʵ�������Ϣ�Թ��޸Ļ��ߵ����Ĳ�ѯ
		public Ingredient get(String name);

		List<Ingredient> getPage(int pageNo, int pageSize);
		 
}
