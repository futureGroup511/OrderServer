﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link rel="stylesheet" type="text/css" href="../css/index.css" />
</head>
<body>
	
   <div class="box">
   
       <div class="tubiao">
           <img src="../images/logo.png" />
       </div>
       <div class="content" >
            <div class="zhujiemian">
                <font color="#858585" size="+1" face="Verdana, Geneva, sans-serif">账户</font>
                <div style="margin-top:10px;margin-bottom:10px">
                <form method="post" action="<%=path%>/users/User_login.action"  >
                   <input class="rounded" type="text" name="phone" autocomplete="on"
                   required="required"
                   placeholder="请输入您的手机号"
                   title="手机号不能为空不能为空"
                   outline:none 
                   >
              		
                </div>
                <font color="#858585" size="+1" face="Verdana, Geneva, sans-serif">密码</font>
                <div style="margin-top:10px;margin-bottom:50px">
                	
                   <input class="rounded" type="password" name="password" 
                   required="required"
                   placeholder="请输入数字字母组成的密码"
                   pattern="^[A-Za-z0-9]+$"
                   outline:none 
                   	
                   />
                
                </div>
                <div>
					  <font color="red"><s:fielderror/> <!-- 显示表单验证的出错信息  对应addFileError --></font>
				</div>
                <a href="${rootPath }zhuce.jsp" target="_blank"><font size="+1">注册</font></a>
                <div style=" float:right;margin-right:15px;">
                <!-- ###############################################以后要取消的-->
                
               <input type="submit" class="button"  value="登录" />
             </form>
             	
                </div>
            </div>
       </div>
        <p align="center"  style="margin-top:70px"><font color="#858585">未来工作室</font></p>
   </div>
 <div/>
</body>
</html>
