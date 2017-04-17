package com.order.action.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.JSONArray;

import com.order.action.SuperAction;
import com.order.dao.AlllInfoVegetableDAO;
import com.order.dao.impl.VsAllInfoDaoImp;
import com.order.domain.AlllInfoVegetable;
import com.order.service.AllInfoVsAndWinService;
import com.order.service.AlreadyService;
import com.order.utils.GetRequestParams;

public class GoodsAction extends SuperAction{
	
	private static final long serialVersionUID = 1L;
	String respMessage = null;
	PrintWriter pw = null;
	public String getvs(){
		System.out.println("我通过访问呢进来了啊");
		try {
			reques.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			AlllInfoVegetableDAO alllInfoVegetableDAO = new VsAllInfoDaoImp();
			List<AlllInfoVegetable> list = alllInfoVegetableDAO.getall();
			JSONArray jsonArray = AllInfoVsAndWinService.allInfotoJsonArray(list);
			pw = response.getWriter(); 
			respMessage = jsonArray.toString(); 
			System.out.println("返回的报文是"+respMessage+"*******************");
			pw.write(respMessage);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pw != null) {
			pw.flush();  
			pw.close(); 
		}
		
		return null;
	}
 
	public String getwin(){
		System.out.println("酒水我通过访问呢进来了啊");
		
		try {
			reques.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			AlllInfoVegetableDAO alllInfoVegetableDAO = new VsAllInfoDaoImp();
			List<AlllInfoVegetable> list = alllInfoVegetableDAO.getAllwin();
			JSONArray jsonArray = AllInfoVsAndWinService.allInfotoJsonArray(list);
			pw = response.getWriter(); 
			respMessage = jsonArray.toString(); 
			System.out.println("返回的是"+respMessage+"*******************");
			pw.write(respMessage);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (pw != null) {
			pw.flush();  
			pw.close(); 
		}
		return null;
	}
	/**
	 * @return
	 * @功能 为客户端提供获取进度的方法
	 */
	public String getprogress(){
		JSONArray reqjsonArray =null;
		JSONArray resJosnArray =null;
		PrintWriter pw = null;
		try {
			//System.out.println("阿弥陀佛啊啊啊啊");
			reques.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			reqjsonArray =  GetRequestParams.getRequestParams(reques, response);
			resJosnArray = AlreadyService.getpromethod(reqjsonArray);
			
			pw = response.getWriter();
			//System.out.println(resJosnArray.toString()+"******的事发生的******");
			pw.write(resJosnArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		pw.write(resJosnArray.toString());
		if (pw !=null) {
			pw.flush();
			pw.close();
		}
		return null;
	}
	
	public String findSource(){
		JSONArray reqjsonArray =null;
		JSONArray resJosnArray =null;
		PrintWriter pw = null;
		try {
			//System.out.println("阿弥陀佛啊啊啊啊");
			//注意：可将这部分更改为filter
			reques.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			reqjsonArray =  GetRequestParams.getRequestParams(reques, response);
			System.out.println("goods_findsource:"+reqjsonArray);
			resJosnArray = AlreadyService.getSource(reqjsonArray);
			
			pw = response.getWriter();
			//System.out.println(resJosnArray.toString()+"******的事发生的******");
			pw.write(resJosnArray.toString());
			System.out.println(resJosnArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	
	
}
