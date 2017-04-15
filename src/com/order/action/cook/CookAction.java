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
 * @author ���
 *@���� ���ദ�������ķ���������
 */
public class CookAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	PrintWriter pw = null;
	//�ṩ�������¼�ķ���
	public String login(){
		JSONObject reqJsonObject;
		JSONObject resJsonObject = null;
		
		try {
			System.out.println("��¼����������");
			reqJsonObject = GetRequestParams.getRequestParams2(reques, response);//�����͵Ĳ���ת��ΪjsonObject
			//�ò�����Ѱ���ݿ⣬�����ض�Ӧ��Ҫ���صĽ��
			resJsonObject = CookService.getCook(reqJsonObject);
			System.out.println("���صı���"+resJsonObject);
			pw = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		pw.write(resJsonObject.toString());
		return null;
	}
	
	//�ṩ�����ע��ķ���
	public String register(){
		JSONObject reqJsonObject;
		JSONObject resJsonObject = null;
		
		try {
			System.out.println("ע�᷽��������");
			reqJsonObject = GetRequestParams.getRequestParams2(reques, response);//�����͵Ĳ���ת��ΪjsonObject
			//�ò�����Ѱ���ݿ⣬�����ض�Ӧ��Ҫ���صĽ��
			resJsonObject = CookService.registerCook(reqJsonObject);		//��ҵ���߼��㴦����װ�����ݷ��ص��ͻ���
			
			System.out.println("���صı���"+resJsonObject);
			pw = response.getWriter();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		pw.write(resJsonObject.toString());
		return null;
	}
	
	//Ϊ��ʦ�ͻ��˷�����Ӧ������
	public String getData(){
		//���ص�����Ϊ���š����Ŷ�Ӧ�Ĳ˻��߾ƣ��˻��߾ƶ�Ӧ������
		System.out.println("���ʵ�������ݵķ�����û��aaaa��");
		JSONArray resJSONArray = null;	//��װ��Ҫ�������ݵ�JSONArray
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
	
	//���ͻ��˵�������Ӧ���ŵĵĶ���ʱ�޸Ľ����ֶ�progress��ֵ
	public String  modifyProgress() {
		JSONObject reqJsonObject = null;	//���տͻ��˷������������	
		try {
			reqJsonObject = GetRequestParams.getRequestParams2(reques, response);
			//����service��صķ��������е����ݵó�Ȼ���޸����ݿ��е�����
			OrderService orderService = new OrderServiceImp();
			orderService.modifyProgress(reqJsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
}
