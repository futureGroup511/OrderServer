package com.order.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.oder.domain.service.BaseGoodsInfos;
import com.order.dao.IngredientDAO;
import com.order.dao.OrderDAO;
import com.order.dao.impl.IngredientDAOImp;
import com.order.dao.impl.OrderDAOImp;
import com.order.domain.Ingredient;
/*import com.sun.org.apache.bcel.internal.generic.RETURN;*/

public class IngredientAction extends SuperAction {

	private static final long serialVersionUID = 1L;
	IngredientDAO ingredientDAO = new IngredientDAOImp();
	public  static int pageNo=1;
	private static int pageSize=8;
	private String goodsname;
	private String goodssource;
	private Date buyindate;
	private double price;
	private int num;
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
		List<Ingredient> list = ingredientDAO.getPage(pageNo, pageSize);
		reques.setAttribute("allingredient", list);
		return "queryallin_success";
		
	}
	
	public String queryallin(){
		List<Ingredient> list = ingredientDAO.getPage(1, pageSize);
		reques.setAttribute("allingredient", list);
		return "queryallin_success";
	}
	public String delete(){
		String name =  reques.getParameter("inname");
		//System.out.println(name);
		ingredientDAO.delete(name);
		return "deletein_success";
	}
	
	public String inaddreflect(){
		//System.out.println("我进来了啊啊啊啊啊");
		return "inaddreflect";
	}
	
	//为修改提供一个映射
	public String inmodifyreflect(){
		goodsname  = reques.getParameter("goodsname");
		//System.out.println(goodsname+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		Ingredient ingredient = ingredientDAO.get(goodsname);
		reques.setAttribute("ingredient", ingredient);
		return "inmodifyreflect";
	}
	
	
	
	public void initIngredient() throws ParseException{
		goodsname = reques.getParameter("goodsname");
		goodssource = reques.getParameter("goodssource");
		String date = reques.getParameter("buyindate");
		String strprice = reques.getParameter("price");
		String strnum = reques.getParameter("num");
		System.out.println(strnum);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		buyindate = simpleDateFormat.parse(date);
		price = Double.parseDouble(strprice);
		num = Integer.parseInt(strnum.trim());
		
		
	}
	/**
	 * @return
	 * 修改配料的方法
	 */
	public String inmodify(){
		try {
			initIngredient();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		/*System.out.println(goodsname);
		System.out.println(goodssource);
		System.out.println(buyindate);
		System.out.println(price);
		System.out.println(num);*/
		
		Ingredient ingredient = new Ingredient(goodsname,goodssource,buyindate,price,num);
		//运用提前定义好的方法对信息进行修改
		ingredientDAO.update(ingredient);
		return null;
	}
	
	
	public String addingredient(){
		try {
			initIngredient();
		} catch (ParseException e) {
			//return "addingredient_failure";
		}
		Ingredient ingredient = new Ingredient(goodsname,goodssource,buyindate,price,num);
		ingredientDAO.save(ingredient);
		return "ingredient_add";
	}
	
}
