package com.order.service;

import java.sql.Timestamp;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.order.dao.AlreadyGoodsDAO;
import com.order.dao.FindSourceDAO;
import com.order.dao.OrderDAO;
import com.order.dao.impl.AlreadyGoodsDAOImp;
import com.order.dao.impl.FindSourceDAOImp;
import com.order.dao.impl.OrderDAOImp;
import com.order.domain.Order;
import com.order.domain.client.AlreadyGoods;
import com.order.domain.client.FindSource;

public class AlreadyService {
	/*
	public  static  boolean insert(JSONArray jsonArray){
		JSONObject jsonObject;
		OrderDAO orderDAO = new OrderDAOImp();
		Date date;
		AlreadyGoodsDAO alreadyGoodsDAO = new AlreadyGoodsDAOImp();
		try {
			jsonObject = jsonArray.getJSONObject(jsonArray.length()-1);
			double count = Double.parseDouble(jsonObject.getString("count"));
			int placenum = Integer.parseInt(jsonObject.getString("placenum"));
			String strdate = jsonObject.getString("date");	//�ͻ��˴������ľ�ȷ�����ʱ��
			System.out.println(strdate+"********************************");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ParsePosition pos = new ParsePosition(0);
			date = formatter.parse(strdate, pos);
			System.out.println(date+"*******************************");
			int num=0;
			for (int i = 0; i <jsonArray.length()-1; i++) {
				jsonObject = jsonArray.getJSONObject(i);
				num = Integer.parseInt(jsonObject.getString("num"));
				System.out.println("ÿһ���˵�������"+num);
				System.out.println("���ӵĺ�����"+placenum);
				AlreadyGoods goods = new AlreadyGoods(jsonObject.getString("name"),placenum,num);
				alreadyGoodsDAO.saveAlready(goods);
			}
			
			Order order = new Order(placenum,count,date);
			orderDAO.save(order);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	*/
	
	//�� �޸�

	public  static  boolean insert(JSONArray jsonArray){
		if(jsonArray.length()<2){
			return false;
		}
		try {
			JSONObject o = jsonArray.getJSONObject(0);
			Order order = new Order();
			order.setOrdercount(o.getDouble("ordercount"));
			order.setOrderdate(new Timestamp(new Date().getTime()));
			order.setOrderprogress("δ����");
			order.setTablenum(o.getInt("tablenum"));
			OrderDAO orderDAO = new OrderDAOImp();
			boolean b=orderDAO.save(order);
			if(!b){
				return false;
			}
			AlreadyGoodsDAO alreadyGoodsDAO= new AlreadyGoodsDAOImp();
			for(int i=1;i<jsonArray.length();i++){
				JSONObject eat = (JSONObject) jsonArray.get(i);
				AlreadyGoods alreadyGoods = new AlreadyGoods();
				alreadyGoods.setGoodsname(eat.getString("goodsname"));
				alreadyGoods.setNum(eat.getInt("num"));
				alreadyGoods.setTablenum(eat.getInt("tablenum"));
				alreadyGoodsDAO.saveAlready(alreadyGoods);
			}
			return true;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	/**
	 * ���ܣ����ݽ��յ����ںͺ����Ų�ѯ��Ӧ�Ľ���
	 */
	public static JSONArray getpromethod(JSONArray jsonArray){
		
		JSONObject jsonObject;
		JSONArray rejsonArray=new JSONArray();
		int tablenum = 0;
		Date date= null;
		try {
			//��ô������ź����ڵ�jsonobject
			jsonObject = jsonArray.getJSONObject(0);			
			tablenum = Integer.parseInt(jsonObject.getString("tablenum"));
			
			String strdate = jsonObject.getString("date");	//�ͻ��˴������ľ�ȷ�����ʱ��
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ParsePosition pos = new ParsePosition(0);
			date = formatter.parse(strdate, pos);
			
			OrderDAO orderDAO = new OrderDAOImp();
			String  orderprogress = orderDAO.getpro(tablenum, date);
			System.out.println("getpromethod���������������");
			System.out.println(orderprogress+"******��ȡ�Ľ���******");
			
			rejsonArray.put(new JSONObject().put("result", orderprogress));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rejsonArray;
	}
	
	
	/**
	 * @���� ����jsonArray�д�������ͼƬ��·�������صĻ�Դ��Ϣ
	 * @param jsonArray
	 * @return
	 */
	public static JSONArray getSource(JSONArray jsonArray){
		JSONArray resjsonArray = new JSONArray();
		
		String str,path="";
		try {
			str = jsonArray.getJSONObject(0).getString("goodsId");
			//System.out.println(str+"���ǿͻ��˷������Ķ���");
			path=str+".jpg";
			//System.out.println(path+"�����Լ��ϳɵ�path");
			//����path��ȡ��صĻ�Դ����Ϣ
			FindSourceDAO findSourceDAO = new FindSourceDAOImp();
			List<FindSource> list = findSourceDAO.getSource(path);
			//����õ���Ϣ��װ��jsonArray
			for(int i=0;i<list.size();i++){
				JSONObject jsonObject = new  JSONObject();
				jsonObject.put("name", list.get(i).getGoodsname());
				jsonObject.put("source", list.get(i).getGoodssource());
				jsonObject.put("buydate", list.get(i).getBuyindate());
				jsonObject.put("singleprice", list.get(i).getPrice());
				jsonObject.put("num", list.get(i).getNum());
				resjsonArray.put(jsonObject);
			}
			System.out.println("���Ǵ����ݿ��õĽ��"+resjsonArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resjsonArray;
	}
}
