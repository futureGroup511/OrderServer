package com.order.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.order.domain.AlllInfoVegetable;


public class AllInfoVsAndWinService {
	
	/**
	 * @return
	 * ���ܣ������ݹ�����List����ת��Ϊ��ͻ��˷��͵�JsonArray�ַ���
	 */
	public static JSONArray allInfotoJsonArray(List<AlllInfoVegetable> list){
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject;
		try{
			for(AlllInfoVegetable info:list){
				jsonObject = new JSONObject();
				//����Ϣ�����ӵ�jsonobject������
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
