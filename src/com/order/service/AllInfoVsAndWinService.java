package com.order.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.order.domain.AlllInfoVegetable;


public class AllInfoVsAndWinService {
	
	/**
	 * @return
	 * 功能：将传递过来的List集合转化为向客户端发送的JsonArray字符串
	 */
	public static JSONArray allInfotoJsonArray(List<AlllInfoVegetable> list){
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject;
		try{
			for(AlllInfoVegetable info:list){
				jsonObject = new JSONObject();
				//将信息逐个添加到jsonobject对象中
				jsonObject.put("vsname",info.getGoodsname());
				jsonObject.put("vsdesc", info.getGoodsdesc());
				jsonObject.put("vsprice", info.getPrice());
				jsonObject.put("vspath", info.getPath());
				jsonArray.put(jsonObject);
			}
		}
		catch (Exception e) {
			 e.printStackTrace();
		}
		return jsonArray;
	}
	
	
	
	
	
}
