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
			addFieldError("filleerror", "�������������������������");
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
	 * @throws Exception �쳣���ף��������õĴ����߼��ķ�����
	 * �߼����������쳣���ش�����Ϣ���û�
	 */
	public void parse(String strnum) throws Exception{
		num = Integer.parseInt(strnum);
	}
	
	
	
}
