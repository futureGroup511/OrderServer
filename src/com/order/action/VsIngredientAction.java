package com.order.action;

import com.order.dao.VsInRelativeDAO;
import com.order.dao.impl.VsInRelativeImp;
import com.order.domain.VsInRelative;

import sun.management.VMOptionCompositeData;

public class VsIngredientAction extends SuperAction{

	
	private static final long serialVersionUID = 1L;
	private String vsname;
	private String ingrename;
	private String strnum;
	private int num;
	
	public String reflectvsin(){
		return "reflectvsin";
	}
	
	public String addrelative(){
		try {
			initParam();
		} catch (Exception e) {
			addFieldError("filleerror", "请您在输入框中输入整数！！");
			return "addrelative_success";
		}
		VsInRelativeDAO vsInRelativeDAO = new VsInRelativeImp();
		VsInRelative vsInRelative = new VsInRelative(vsname,ingrename,num);
		vsInRelativeDAO.saveVsIn(vsInRelative);
		
		return "addrelative_success";
	}
	
	public void initParam() throws Exception{
		vsname = reques.getParameter("vsname");
		ingrename = reques.getParameter("ingrename");
		strnum = reques.getParameter("num");
		
		System.out.println(vsname);
		System.out.println(ingrename);
		System.out.println(strnum);
		
		parse(strnum);
	}
	
	/**
	 * @param strnum
	 * @throws Exception 异常上抛，交给调用的处理逻辑的方法，
	 * 逻辑方法处理异常返回错误信息给用户
	 */
	public void parse(String strnum) throws Exception{
		num = Integer.parseInt(strnum);
	}
	
	
	
}
