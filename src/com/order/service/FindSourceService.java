package com.order.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FindSourceService {
	
	public static JSONArray getsource(JSONArray jsonArray){
		JSONObject jsonObject;
		JSONArray resJSONArray = null;
		String strpath=null;
		try {
			jsonObject=jsonArray.getJSONObject(0);
			strpath=jsonObject.getString("goodsId")+".jpg";
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * JSONObject jsonObject = new JSONObject(); 
			jsonObject.put("name", "葱爆羊肉");
			jsonObject.put("source","河南省新乡市红旗区华联超市");
			jsonObject.put("buydate", "2016-5-16");
			jsonObject.put("singleprice", "12/kg");
			jsonObject.put("num", "2");
			
			JSONObject jsonObject2 = new JSONObject(); 
			jsonObject2.put("name", "葱爆羊肉");
			jsonObject2.put("source","河南省新乡市红旗区华联超市");
			jsonObject2.put("buydate", "2016-5-16");
			jsonObject2.put("singleprice", "12/kg");
			jsonObject2.put("num", "2");
			jsonArray.put(jsonObject);
			jsonArray.put(jsonObject2);
		 */
		
		return null;
	}
}
