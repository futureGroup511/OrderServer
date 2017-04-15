package com.order.action.client;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.order.action.SuperAction;
import com.order.dao.AlreadyGoodsDAO;
import com.order.dao.OrderDAO;
import com.order.dao.impl.AlreadyGoodsDAOImp;
import com.order.dao.impl.OrderDAOImp;
import com.order.domain.Order;
import com.order.domain.client.AlreadyGoods;

public class OrderTodayAction extends SuperAction{
	
	//获取今天订单
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		OrderDAO orderDAO = new OrderDAOImp();
		JSONArray jsonArray = new JSONArray();
		List<Order> orders = orderDAO.getAll();
		AlreadyGoodsDAO alreadyGoodsDAO = new AlreadyGoodsDAOImp();
		for(Order o:orders){
			JSONArray one = new JSONArray();
			one.put(new JSONObject(o));
			List<AlreadyGoods> two = alreadyGoodsDAO.getByTablenum(o.getTablenum());
			for(AlreadyGoods ag:two){
				one.put(new JSONObject(ag));
			}
			jsonArray.put(one);
		}
		System.out.println("orderToday:"+jsonArray.toString());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf8");
		response.getWriter().print(jsonArray.toString());
		return null;
	}
}
