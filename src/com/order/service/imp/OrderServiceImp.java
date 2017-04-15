package com.order.service.imp;

import org.json.JSONObject;
import com.order.dao.OrderDAO;
import com.order.dao.impl.OrderDAOImp;
import com.order.service.OrderService;

public class OrderServiceImp implements OrderService{
	private static final String RECEPT = "����";
	private static final String FINISH = "���";
	/**
	 * ���ܣ�ʵ�ֻ�ȡ�ͻ��˷�װ���ַ�
	 * ��������Ӧ���ַ��޸����ݿ�����Ӧ���ֶ�
	 */
	@Override
	public void modifyProgress(JSONObject jsonObject) {
		String progressStr =null;
		String tablenumStr= null;
		int tablenum = 0;
		try {
			progressStr = jsonObject.getString("progress");
			tablenumStr = jsonObject.getString("table");
			tablenum = Integer.parseInt(tablenumStr);
			//����DAO����Ӧ�ķ������޸���Ӧ���ֶ�
			OrderDAO orderDAO = new OrderDAOImp();
			if (progressStr.equals("1")) {
				System.out.println(1);
				orderDAO.update(tablenum, RECEPT);
			}else {
				System.out.println(2);
				orderDAO.update(tablenum, FINISH);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
