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
 * @author ���
 * @implements ModelDriven�ӿ�
 * ��˼�ǰ�ʵ���൱��jspҳ�������ռ��Ķ���
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
	
	//��¼�ķ�������ȡ�ŵ���ص���Ϣ��ʾ�ڲ˱���
	public String login(){
		
		if ((userDao.getUser(user.getPhone(), user.getPassword())) != null) {
			session.setAttribute("loginUserName", "����"+user.getPhone());
			//��ӻ�ȡ�˱���Ϣ����ص��߼�
			//System.out.println(pageNo+"dsdsdsdd");
			List<BaseGoodsInfos> baseList = vegetableDAO.getPage(1, pageSize);
			//System.out.println(baseList.get(1).getGoodsname());
			reques.setAttribute("vegetables", baseList);
			return "login_success";
		}
		else{
			addFieldError("loginErrorMessage", "�˺Ż����������");
			return "login_failure";
		}
	}
	public String register(){
		String phone = reques.getParameter("phone");
		String password = reques.getParameter("password");
		String repassword = reques.getParameter("repassword");
		User isAlready = userDao.get(phone);
		if (isAlready !=null) {
			addFieldError("phone_already", "���û��ѽ����ڣ����������ֻ���");
			return "phone_already";
		}else{
		//System.out.println("phone:"+phone+"password:"+password+"repassword:"+repassword);
			if (phone.length() !=11) {
				//����ֻ��ŵĳ��Ȳ�����11
				addFieldError("wronglength", "�ֻ��ų��Ȳ���11λ");
				return "wrong_length";
			}else{
				if (password.equals(repassword)) {
					User user = new User(phone,password);
					userDao.save(user);
					return "register_success";
				}else{
					//��������ȷ�ϵ����벻��ͬ
					addFieldError("notequal", "�����ȷ�����벻��ͬ");
					return "register_notequal";
				}
			}
		}
	}
	
	//�û�ע���ķ���
	@SkipValidation			//ʹ�÷�������validate���������в�������֤
	public String logout(){				
		if (session.getAttribute("loginUserName")!=null) {
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
}
