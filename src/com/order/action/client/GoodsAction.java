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
		System.out.println("��ͨ�������ؽ����˰�");
		try {
			reques.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			AlllInfoVegetableDAO alllInfoVegetableDAO = new VsAllInfoDaoImp();
			List<AlllInfoVegetable> list = alllInfoVegetableDAO.getall();
			JSONArray jsonArray = AllInfoVsAndWinService.allInfotoJsonArray(list);
			pw = response.getWriter(); 
			respMessage = jsonArray.toString(); 
			System.out.println("���صı�����"+respMessage+"*******************");
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
		System.out.println("��ˮ��ͨ�������ؽ����˰�");
		
		try {
			reques.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			AlllInfoVegetableDAO alllInfoVegetableDAO = new VsAllInfoDaoImp();
			List<AlllInfoVegetable> list = alllInfoVegetableDAO.getAllwin();
			JSONArray jsonArray = AllInfoVsAndWinService.allInfotoJsonArray(list);
			pw = response.getWriter(); 
			respMessage = jsonArray.toString(); 
			System.out.println("���ص���"+respMessage+"*******************");
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
	 * @���� Ϊ�ͻ����ṩ��ȡ���ȵķ���
	 */
	public String getprogress(){
		JSONArray reqjsonArray =null;
		JSONArray resJosnArray =null;
		PrintWriter pw = null;
		try {
			//System.out.println("�����ӷ𰡰�����");
			reques.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			reqjsonArray =  GetRequestParams.getRequestParams(reques, response);
			resJosnArray = AlreadyService.getpromethod(reqjsonArray);
			
			pw = response.getWriter();
			//System.out.println(resJosnArray.toString()+"******���·�����******");
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
			//System.out.println("�����ӷ𰡰�����");
			//ע�⣺�ɽ��ⲿ�ָ���Ϊfilter
			reques.setCharacterEncoding("UTF-8");
			response.setContentType("text/json;charset=UTF-8");
			reqjsonArray =  GetRequestParams.getRequestParams(reques, response);
			System.out.println("goods_findsource:"+reqjsonArray);
			resJosnArray = AlreadyService.getSource(reqjsonArray);
			
			pw = response.getWriter();
			//System.out.println(resJosnArray.toString()+"******���·�����******");
			pw.write(resJosnArray.toString());
			System.out.println(resJosnArray.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
	
	
}
