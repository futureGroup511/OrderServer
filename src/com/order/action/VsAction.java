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
	//查询所有的菜的信息
	public String queryAllVs(){
		List<BaseGoodsInfo> baseList = vegetableDAO.getAll();
		reques.setAttribute("vegetables", baseList);
		return "vsqueryall_success";
	}
	//删除对应的菜的信息
	public String  deleteVs(){
		String name=reques.getParameter("vsname");
		//System.out.println(name+"************");
		vegetableDAO.delete(name);
		return "deletevs_success";
	}
	
	//由于WEB-INF中的资源用户不能直接的访问，所以提供一个方法映射到指定的资源
	public String vsaddreflect(){
		//System.out.println("我进来了啊啊啊啊啊");
		return "vsaddreflect";
	}
	//为修改提供一个映射
	public String vsmodifyreflect(){
		goodsname = reques.getParameter("goodsname");
		BaseGoodsInfo vegetable = vegetableDAO.get(goodsname);
		
		reques.setAttribute("vegetable", vegetable);
		
		return "vsmodifyreflect";
	}
	
	//修改
	public String vsmodify(){
		
		String strgoodsname = reques.getParameter("goodsname");
		price = reques.getParameter("price");
		goodsdesc = reques.getParameter("goodsdesc");
		
		BaseGoodsInfo vegetable =  new BaseGoodsInfo(strgoodsname,goodsdesc,price);
		vegetableDAO.update(vegetable);
		return null;
	}
	
}
