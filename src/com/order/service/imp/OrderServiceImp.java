package com.order.service.imp;

import org.json.JSONObject;
import com.order.dao.OrderDAO;
import com.order.dao.impl.OrderDAOImp;
import com.order.service.OrderService;

public class OrderServiceImp implements OrderService{
	private static final String RECEPT = "接收";
	private static final String FINISH = "完成";
	/**
	 * 功能：实现获取客户端封装的字符
	 * 并根据相应的字符修改数据库中相应的字段
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
			//调用DAO层相应的方法将修改相应的字段
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
