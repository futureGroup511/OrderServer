package com.order.action.cook;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.order.action.SuperAction;
import com.order.dao.impl.OrderDAOImp;
import com.order.service.CookService;
import com.order.service.OrderService;
import com.order.service.imp.OrderServiceImp;
import com.order.utils.GetRequestParams;

/**
 * @author 秋放
 *@功能 此类处理做饭的发出的请求
 */
public class CookAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	//提供给大厨登录的方法
	public String login(){
		JSONObject reqJsonObject;
		JSONObject resJsonObject = null;
		
		try {
			System.out.println("登录方法进来了");
			reqJsonObject = GetRequestParams.getRequestParams2(reques, response);//将发送的参数转换为jsonObject
			//用参数搜寻数据库，并返回对应的要返回的结果
			resJsonObject = CookService.getCook(reqJsonObject);
			System.out.println("返回的报文"+resJsonObject);
			pw = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		pw.write(resJsonObject.toString());
		return null;
	}
	
	//提供给大厨注册的方法
	public String register(){
		JSONObject reqJsonObject;
		JSONObject resJsonObject = null;
		
		try {
			System.out.println("注册方法进来了");
			reqJsonObject = GetRequestParams.getRequestParams2(reques, response);//将发送的参数转换为jsonObject
			//用参数搜寻数据库，并返回对应的要返回的结果
			resJsonObject = CookService.registerCook(reqJsonObject);		//将业务逻辑层处理并封装的数据返回到客户端
			
			System.out.println("返回的报文"+resJsonObject);
			pw = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		pw.write(resJsonObject.toString());
		return null;
	}
	
	//为厨师客户端返回相应的数据
	public String getData(){
		//返回的数据为桌号、桌号对应的菜或者酒，菜或者酒对应的数量
		System.out.println("访问到获得数据的方法了没有aaaa？");
		JSONArray resJSONArray = null;	//封装了要返回数据的JSONArray
		resJSONArray = CookService.getData();
		try {
			response.setCharacterEncoding("utf-8");
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("resJSONArray.toString()efefefefefefefefef"+resJSONArray.toString());
		pw.write(resJSONArray.toString());
		return null;
	}
	
	//当客户端点击完成相应桌号的的订单时修改进度字段progress的值
	public String  modifyProgress() {
		JSONObject reqJsonObject = null;	//接收客户端发来的请求参数	
		try {
			reqJsonObject = GetRequestParams.getRequestParams2(reques, response);
			//调用service相关的方法将其中的数据得出然后修改数据库中的内容
			OrderService orderService = new OrderServiceImp();
			orderService.modifyProgress(reqJsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
