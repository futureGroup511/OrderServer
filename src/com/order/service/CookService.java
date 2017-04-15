package com.order.service;

import java.net.URLEncoder;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.order.dao.AlreadyGoodsDAO;
import com.order.dao.CookDAO;
import com.order.dao.OrderDAO;
import com.order.dao.impl.AlreadyGoodsDAOImp;
import com.order.dao.impl.CookDAOImp;
import com.order.dao.impl.OrderDAOImp;
import com.order.domain.Already;
import com.order.domain.Order;
import com.order.domain.client.AlreadyGoods;
import com.order.domain.cook.Cook;

public class CookService {
	
	public static JSONObject getCook(JSONObject jsonObject){
		String name,password;
		Cook cook=null;
		JSONObject resJsonObject = new JSONObject();
		try {
			name = jsonObject.getString("name");
			password = jsonObject.getString("passWord");
			CookDAO cookDAO = new CookDAOImp();
			cook = cookDAO.getCook(name, password);
			if (cook!=null) {
				resJsonObject.put("login", "succuss");
			}else {
				resJsonObject.put("login", "falier");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resJsonObject;
	}
	
	/**
	 * @param jsonObject
	 * @return
	 * @ ������Ӧ��ע����Ϣʵ��ע��ҵ���߼��ķ���
	 */
	public static JSONObject registerCook(JSONObject jsonObject){
		String name,password;
		Cook cook=null;
		JSONObject resJsonObject = new JSONObject();
		try {
			name = jsonObject.getString("name");
			password = jsonObject.getString("passWord");
			CookDAO cookDAO = new CookDAOImp();
			cook = cookDAO.getCookByName(name);
			//�ж����ݿ����Ƿ����Ҫע����û���
			if (cook!=null) {
				resJsonObject.put("regist", "same");
			}else {	//������ݿ��в�����
				//���ͻ��˴�������ע����Ϣ�������ݿ��У�Ȼ�󷵻���Ӧ����Ϣ
				cookDAO.saveCook(name, password);
				resJsonObject.put("regist", "qq");
			}
		} catch (Exception e) {
			try {
				resJsonObject.put("regist", "exception");
			} catch (JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return resJsonObject;
	}
	
	//�������еĲ˵���Ϣ
	public static JSONArray getData(){
		JSONArray jsonArray= new JSONArray();
		JSONArray itemsJSONArray =  null;
		JSONArray vegetableJSONArray = null;
		JSONArray numJSONArray = null;
		Order order = null;
		OrderDAO orderDAO = new OrderDAOImp();	//��������������ʵ��
		AlreadyGoodsDAO alreadyGoodsDAO = new AlreadyGoodsDAOImp(); //��������������ʵ��
		List<Order> orders = orderDAO.getNotReceiveOrder("δ����");		//��ȡ����δ���յĶ���
		System.out.println(orders.size()+"******************************");
		for(int i = 0;i<orders.size();i++){
			
			try {
				itemsJSONArray = new JSONArray();
				order = orders.get(i);		//��ȡ��ǰ��order����
				System.out.println("order"+order);
				orderDAO.update(order.getTablenum(), "����");
				JSONArray jsonArrayGET = getVegetable(order.getTablenum(),alreadyGoodsDAO);
				vegetableJSONArray = jsonArrayGET.getJSONArray(0);	
				numJSONArray = jsonArrayGET.getJSONArray(1);
				System.out.println("order"+order.getTablenum());
				itemsJSONArray.put(0,order.getTablenum());	//��������
				itemsJSONArray.put(1,order.getOrderprogress());	//�������
				itemsJSONArray.put(2,vegetableJSONArray);	//�������Ŷ�Ӧ���в˵�����
				itemsJSONArray.put(3,numJSONArray);	//�������Ŷ�Ӧ���в˵�����
				System.out.println("itemsJSONArray"+itemsJSONArray.toString());
				jsonArray.put(itemsJSONArray);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			// itemsJSONArray;
		}
		System.out.println("jsonArray"+jsonArray.toString());
		return jsonArray;
	}
	
	//������Ӧ�����Ų�ѯ���Ӧ�Ĳˣ�Ȼ���װ��jsonArray��
	public static JSONArray getVegetable(int tablenum,AlreadyGoodsDAO alreadyGoodsDAOImp){
		JSONArray jsonArray = new JSONArray();
		JSONArray jsonArray1 = new JSONArray();		//�Ŷ�Ӧ���ӵ����еĲ�
		JSONArray jsonArray2 = new JSONArray();		//�Ŷ�Ӧ�����ӵ����в˵�����
		List<AlreadyGoods> alreadies = alreadyGoodsDAOImp.getAll();
		for(AlreadyGoods alreadyGoods :alreadies){
			jsonArray1.put(alreadyGoods.getGoodsname());
			jsonArray2.put(alreadyGoods.getNum());
			
		}
		jsonArray.put(jsonArray1);
		jsonArray.put(jsonArray2);
		return jsonArray;
	}
	
	
}
