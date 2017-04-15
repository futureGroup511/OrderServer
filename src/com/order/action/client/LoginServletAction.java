package com.order.action.client;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONObject;

import com.order.action.SuperAction;
import com.order.dao.CustomerDao;
import com.order.dao.impl.CustomerDaoImp;
import com.order.domain.Customer;

public class LoginServletAction extends SuperAction{
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		InputStream inputStream = request.getInputStream();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=utf8");
		int length = request.getContentLength();
		if(length<0){
			response.getWriter().append("[{\"userId\":0}]");
			return null;
		}
		int hasRead = 0;
		byte[] buffer = new byte[length];
		while(hasRead<length){
			int x = inputStream.read(buffer,hasRead,length-hasRead);
			hasRead += x;
		}
		String json = new String(buffer);
		JSONArray users = new JSONArray(json);
		JSONObject user = (JSONObject) users.get(0);
		String username= user.getString("username");
		String password = user.getString("password");
		CustomerDao customerDao = new CustomerDaoImp();
		Customer customer = customerDao.login(username, password);
		if(null == customer){
			response.getWriter().append("[{\"userId\":0}]");
		}else{
			response.getWriter().append("[{\"userId\":1}]");
		}
		return null;
	}	
}
