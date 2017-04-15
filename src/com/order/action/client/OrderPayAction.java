package com.order.action.client;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;

import com.order.action.SuperAction;
import com.order.dao.AlreadyGoodsDAO;
import com.order.dao.OrderDAO;
import com.order.dao.impl.AlreadyGoodsDAOImp;
import com.order.dao.impl.OrderDAOImp;
import com.order.domain.Order;

public class OrderPayAction extends SuperAction{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			InputStream inputStream = request.getInputStream();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf8");
			int length = request.getContentLength();
			if (length < 0) {
				response.getWriter().print("{\"result\":1,\"error\":\"失败,请求信息有误.\"}");
				return null;
			}
			int hasRead = 0;
			byte[] buffer = new byte[length];
			while (hasRead < length) {
				int x = inputStream.read(buffer, hasRead, length - hasRead);
				hasRead += x;
			}
			String json = new String(buffer);
			JSONObject req = new JSONObject(json);
			int tablenum = req.getInt("tablenum");
			OrderDAO orderDAO = new OrderDAOImp();
			List<Order> orders = orderDAO.getNoFinish(tablenum);
			if(orders==null || orders.isEmpty()){
				response.getWriter().print("{\"result\":2,\"error\":\"失败,未查询到相关订单.\"}");
				return null;
			}
			Order order = orders.get(0);
			if(!"完成".equals(order.getOrderprogress())){
				response.getWriter().print("{\"result\":3,\"error\":\"失败,订单未完成,无法付款.请等待厨师完成.\"}");
				return null;
			}
			orderDAO.update(tablenum, "付款");
			AlreadyGoodsDAO alreadyGoodsDAO = new AlreadyGoodsDAOImp();
			alreadyGoodsDAO.deleteAll(tablenum);
			response.getWriter().print("{\"result\":0}");
			return null;
		}catch (Exception e) {
			// TODO: handle exception
			response.getWriter().print("{\"result\":4,\"数据库操作失败.\"}");
		}
		return null;
	}
}
