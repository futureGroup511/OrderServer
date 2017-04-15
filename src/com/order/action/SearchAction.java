package com.order.action;

import java.util.List;

import com.order.dao.IngredientDAO;
import com.order.dao.OrderDAO;
import com.order.dao.VegetableDAO;
import com.order.dao.impl.IngredientDAOImp;
import com.order.dao.impl.OrderDAOImp;
import com.order.dao.impl.VegetableDAOImp;
import com.order.dao.impl.WinDAOImp;
import com.order.domain.BaseGoodsInfo;
import com.order.domain.Ingredient;
import com.order.domain.Order;

public class SearchAction extends SuperAction{

	
	private static final long serialVersionUID = 1L;
	
	
	public String search(){
		String search = reques.getParameter("search");
		String keyname = reques.getParameter("keyname").trim();
		System.out.println(search);
		System.out.println(keyname);
		switch (search) {
			case "菜表":
				
				if (searchvs(keyname)!=null && searchvs(keyname).size() != 0) {
					reques.setAttribute("vegetables", searchvs(keyname));
					reques.setAttribute("search", "search");
					return "searchvs_success";
				}else{
					addFieldError("fileerror", "未找到相关菜单！");
					return "searchvs_success";
				}
				
			case "酒水":
				
				if (searchwin(keyname)!=null && searchwin(keyname).size() != 0) {
					reques.setAttribute("allwin", searchwin(keyname));
					reques.setAttribute("search", "search");
					return "searchwin_success";
				}else{
					addFieldError("fileerror", "未找到相关酒水！");
					return "searchwin_success";
				}
			case "配料":
				
				if (searchin(keyname)!=null && searchin(keyname).size() != 0) {
					reques.setAttribute("allingredient", searchin(keyname));
					reques.setAttribute("search", "search");
					return "searchin_success";
				}else{
					addFieldError("fileerror", "未找到相关配料！");
					return "searchin_success";
				}
				
			case "订单":
				
				int tablenum;
				try {
					tablenum = Integer.parseInt(keyname);
				} catch (NumberFormatException e) {
					addFieldError("fileerror", "未找到相关订单！");
					
					return "searchorder_success";
				}
				
				if (searchorder(tablenum)!=null && searchorder(tablenum).size() != 0) {
					
					List<Order> list = searchorder(tablenum);
					if(list.size()>0){
						double sum=0;
						for(Order o:list){
							sum=sum+o.getOrdercount();
						}
						reques.setAttribute("allorder", list);
						reques.setAttribute("search", "search");
						reques.setAttribute("sum", sum);
					}
					return "searchorder_success";
				}else{
					
					addFieldError("fileerror", "未找到相关订单！");
					return "searchorder_success";
				}
				
			default:
				break;
		}
		return null;
	}
	
	//锟斤拷询锟剿的凤拷锟斤拷
	public List<BaseGoodsInfo> searchvs(String name){
		VegetableDAO vegetableDAO = new VegetableDAOImp();
		List<BaseGoodsInfo> baseList = vegetableDAO.getAll(name);
		
		//System.out.println(baseList.get(0).getGoodsdesc());
		return baseList;
	}
	
	//锟斤拷询锟剿的凤拷锟斤拷
	public List<BaseGoodsInfo> searchwin(String name){
		VegetableDAO vegetableDAO = new WinDAOImp();
		List<BaseGoodsInfo> baseList = vegetableDAO.getAll(name);
		//System.out.println(baseList.get(0).getGoodsdesc()+"&&&&&&&&&&&&&&&&&&");
		return baseList;
	}
	
	//锟斤拷询锟斤拷锟较的凤拷锟斤拷
	public List<Ingredient> searchin(String name){
		IngredientDAO ingredientDAO = new IngredientDAOImp();
		List<Ingredient> inList = ingredientDAO.getAll(name);
		//System.out.println(inList.get(0).getGoodssource());
		return inList;
	}
	
	public List<Order> searchorder(int tablenum){
		OrderDAO orderDAO = new OrderDAOImp();
		List<Order> orderlist = orderDAO.getAll(tablenum);
		//System.out.println("锟斤拷锟角碉拷一锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷"+orderlist.get(0).getOrderdate()+"锟斤拷锟斤拷锟斤拷锟斤拷");
		return orderlist;
	}
	
}
