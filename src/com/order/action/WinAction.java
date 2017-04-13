package com.order.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.oder.domain.service.BaseGoodsInfos;
import com.order.dao.VegetableDAO;
import com.order.dao.impl.WinDAOImp;
import com.order.domain.BaseGoodsInfo;

public class WinAction extends SuperAction {

	private static final long serialVersionUID = 1L;
	public  static int pageNo=1;
	private static int pageSize=8;
	
	VegetableDAO winDao = new WinDAOImp();
	private String goodsname;
	private String goodsdesc;
	private String price;
	//查询出所有的酒相关的信息
	public String page(){
		int number=3;
		 
		String numbers=ServletActionContext.getRequest().getParameter("number");
		if(numbers!=null&&!numbers.equals(""))
		{
			  number=Integer.parseInt(numbers);
			
		}
		
		if(number==1){
			pageNo--;
			if(pageNo<1){
				pageNo=1;
			}
	
		 
		}
		if(number==2){
			pageNo++;
			 
		}
		if(number==3){
			pageNo=1;
		
		}
		System.out.println(pageNo);
		List<BaseGoodsInfos> baseList = winDao.getPage(pageNo, pageSize);
		reques.setAttribute("allwin",baseList);
		return "queryallwin_success";
		
	}
	
	public String queryAllWin(){
		List<BaseGoodsInfos> baseList = winDao.getPage(pageNo, pageSize);
		reques.setAttribute("allwin",baseList);
		return "queryallwin_success";
	}
	//删除信息的方法
	public String delete(){
		String winname = reques.getParameter("winname");
		winDao.delete(winname);
		return "deletewin_success";
	}
	
	public String winaddreflect(){
		//System.out.println("我进来了啊啊啊啊啊");
		
		return "winaddreflect";
	}
	
	//为修改提供一个映射
	public String winmodifyreflect(){
		goodsname = reques.getParameter("goodsname");
		//System.out.println(goodsname);
		BaseGoodsInfo win = winDao.get(goodsname);
		reques.setAttribute("win", win);
		
		return "winmodifyreflect";
	}
	
	public String winmodify(){
		System.out.println("我通过表单的提交进来了啊");
		String strgoodsname = reques.getParameter("goodsname");
		goodsdesc = reques.getParameter("goodsdesc");
		price = reques.getParameter("price");
		System.out.println(strgoodsname);
//		System.out.println(goodsdesc);
//		System.out.println(price);
		
		BaseGoodsInfo wInfo = new BaseGoodsInfo(strgoodsname,goodsdesc,price);
		winDao.update(wInfo);	
		return null;
	}
}
