package com.order.action.client;

import java.io.IOException;
import java.io.PrintWriter;

import org.json.JSONArray;

import com.order.action.SuperAction;
import com.order.service.AlreadyService;
import com.order.utils.GetRequestParams;

public class OrderSubmitAction extends SuperAction{
	
	//提交订单
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		JSONArray reqJsonArray=null;
		try {
			reqJsonArray = GetRequestParams.getRequestParams(reques, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setContentType("text/html;charset=utf8");
		System.out.println("orderSubmit:"+reqJsonArray);
		
		boolean b = AlreadyService.insert(reqJsonArray);
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
		if(b){
			pw.print("{\"result\":0}");
		}else{
			pw.print("{\"result\":1,\"error\":\"当前桌子的订单还未完成,请更换桌子!\"}");
		}
		return null;
	}

}
