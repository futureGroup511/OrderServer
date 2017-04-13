package com.order.action;

import java.util.List;

import com.order.dao.VegetableDAO;
import com.order.dao.impl.VegetableDAOImp;
import com.order.domain.BaseGoodsInfo;

public class VsAction extends SuperAction {

	private static final long serialVersionUID = 1L;
	VegetableDAO vegetableDAO = new VegetableDAOImp();
	private String goodsname;
	private String price;
	private String goodsdesc;
	//��ѯ���еĲ˵���Ϣ
	public String queryAllVs(){
		List<BaseGoodsInfo> baseList = vegetableDAO.getAll();
		reques.setAttribute("vegetables", baseList);
		return "vsqueryall_success";
	}
	//ɾ����Ӧ�Ĳ˵���Ϣ
	public String  deleteVs(){
		String name=reques.getParameter("vsname");
		//System.out.println(name+"************");
		vegetableDAO.delete(name);
		return "deletevs_success";
	}
	
	//����WEB-INF�е���Դ�û�����ֱ�ӵķ��ʣ������ṩһ������ӳ�䵽ָ������Դ
	public String vsaddreflect(){
		//System.out.println("�ҽ����˰���������");
		return "vsaddreflect";
	}
	//Ϊ�޸��ṩһ��ӳ��
	public String vsmodifyreflect(){
		goodsname = reques.getParameter("goodsname");
		BaseGoodsInfo vegetable = vegetableDAO.get(goodsname);
		
		reques.setAttribute("vegetable", vegetable);
		
		return "vsmodifyreflect";
	}
	
	//�޸�
	public String vsmodify(){
		
		String strgoodsname = reques.getParameter("goodsname");
		price = reques.getParameter("price");
		goodsdesc = reques.getParameter("goodsdesc");
		
		BaseGoodsInfo vegetable =  new BaseGoodsInfo(strgoodsname,goodsdesc,price);
		vegetableDAO.update(vegetable);
		return null;
	}
	
}
