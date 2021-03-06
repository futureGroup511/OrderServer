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

public class ChangePasswordAction extends SuperAction {
	@Override
	public String execute() {
		// TODO Auto-generated method stub
		try {
			HttpServletRequest request = ServletActionContext.getRequest();
			InputStream inputStream = request.getInputStream();
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=utf8");
			int length = request.getContentLength();
			System.out.println("len:"+length);
			if (length < 0) {
				System.out.println("length:"+length);
				return null;
			}
			int hasRead = 0;
			byte[] buffer = new byte[length];
			while (hasRead < length) {
				int x = inputStream.read(buffer, hasRead, length - hasRead);
				hasRead += x;
			}
			String json = new String(buffer);
			System.out.println("changepassword:"+json);
			JSONArray users = new JSONArray(json);
			JSONObject user = (JSONObject) users.get(0);
			
			String username = user.getString("username");
			String password = user.getString("password");
			CustomerDao customerDao = new CustomerDaoImp();
			boolean b = customerDao.change(username, password);
			System.out.println(b);
			response.getWriter().print(b ? "[{\"userId\":1}]" : "[{\"userId\":0}]");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
}
