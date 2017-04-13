package com.order.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionSupport;

//���е�Action�����ĸ���
public class SuperAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ServletContextAware{
	
	private static final long serialVersionUID = 1L;
	protected HttpServletRequest reques;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected ServletContext application;	//ȫ�ֶ���
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.reques = request;
		this.session = this.reques.getSession();
	}
	
	@Override
	public void setServletContext(ServletContext application) {
		this.application = application;
	}
}
