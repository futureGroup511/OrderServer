package com.order.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.oder.domain.service.BaseGoodsInfos;
import com.opensymphony.xwork2.ModelDriven;
import com.order.dao.UserDao;
import com.order.dao.VegetableDAO;
import com.order.dao.impl.UserDaoImp;
import com.order.dao.impl.VegetableDAOImp;
import com.order.domain.BaseGoodsInfo;
import com.order.domain.User;

/**
 * @author 秋放
 * @implements ModelDriven接口
 * 意思是把实体类当做jsp页面数据收集的对象
 */
public class UserAction extends SuperAction implements ModelDriven<User>{

	
	
	private  static int pageNo=1;
	private static int pageSize=8;
	
	private User user = new User();
	UserDao userDao = new UserDaoImp();
	VegetableDAO vegetableDAO = new VegetableDAOImp();

	@Override
	public User getModel() {
		return this.user;
	}
	
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
		List<BaseGoodsInfos> baseList = vegetableDAO.getPage(pageNo, pageSize);   
		reques.setAttribute("vegetables", baseList);
		return "login_success";
		
	}
	
	//登录的方法并获取才的相关的信息显示在菜表中
	public String login(){
		
		if ((userDao.getUser(user.getPhone(), user.getPassword())) != null) {
			session.setAttribute("loginUserName", "您好"+user.getPhone());
			//添加获取菜表信息的相关的逻辑
			//System.out.println(pageNo+"dsdsdsdd");
			List<BaseGoodsInfos> baseList = vegetableDAO.getPage(1, pageSize);
			//System.out.println(baseList.get(1).getGoodsname());
			reques.setAttribute("vegetables", baseList);
			return "login_success";
		}
		else{
			addFieldError("loginErrorMessage", "账号或者密码错误");
			return "login_failure";
		}
	}
	public String register(){
		String phone = reques.getParameter("phone");
		String password = reques.getParameter("password");
		String repassword = reques.getParameter("repassword");
		User isAlready = userDao.get(phone);
		if (isAlready !=null) {
			addFieldError("phone_already", "此用户已将存在！请您更换手机号");
			return "phone_already";
		}else{
		//System.out.println("phone:"+phone+"password:"+password+"repassword:"+repassword);
			if (phone.length() !=11) {
				//如果手机号的长度不等于11
				addFieldError("wronglength", "手机号长度不足11位");
				return "wrong_length";
			}else{
				if (password.equals(repassword)) {
					User user = new User(phone,password);
					userDao.save(user);
					return "register_success";
				}else{
					//如果密码和确认的密码不相同
					addFieldError("notequal", "密码和确认密码不相同");
					return "register_notequal";
				}
			}
		}
	}
	
	//用户注销的方法
	@SkipValidation			//使该方法逃脱validate方法对所有操作的验证
	public String logout(){				
		if (session.getAttribute("loginUserName")!=null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
}
