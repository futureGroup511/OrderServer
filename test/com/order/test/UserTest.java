package com.order.test;

import org.junit.Test;

import com.order.dao.UserDao;
import com.order.dao.impl.UserDaoImp;
import com.order.domain.User;

public class UserTest {
	
	@Test
	public void save(){
		//相当于注册
		User user = new User();
		user.setPhone("15738308889");
		user.setPassword("1994wobuzhidao");
		UserDao userDao = new UserDaoImp();
		userDao.save(user);
	}
	
	@Test
	public void get(){
		//相当于登录
		User user = null;
		
		UserDao userDao = new UserDaoImp();
		user = userDao.getUser("15738308889", "1994wobuzhidao");
		System.out.println(user.getPhone()+"******"+user.getPassword());
	}
	
	@Test
	public void getUser(){
		UserDao userDao = new UserDaoImp();
		User user =userDao.get("15738308889");
		
		System.out.println(user.getPhone()+"******"+user.getPassword());
	}
	
}
