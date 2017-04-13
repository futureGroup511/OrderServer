<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<link rel="stylesheet" type="text/css" href="css/zhuce.css" />
</head>
<body>
     <div class="head">
          <div class="szuo">
              <a href="${rootPath }"><img src="images/logo.png" /></a>
          </div>
          <div class="syou">
              <a href="index.jsp"><font>登录</font></a>
              <font size="+1" color="#999">|</font>
              <a href="zhuce.jsp"><font>注册</font></a>
          </div>
     </div>
     <div class="box">
           <div class="zhuce">
                <font size="+2" color="#6EA7EB">|</font>
                <font size="+1" color="#999">注册</font>
           </div>
           <div class="main">
            <!--输入用户名***********************************************-->
                <div style="width:400px">
                     <div class="text">
                         <font size="4" color="#999">用户名</font>
                     </div>
                     <div class="input">
                    <form method="post" action="<%=path%>/users/User_register"  >
                          <input type="text" name="phone" class="rounded"
                          style="float:left"
                          placeholder="请输入一个用户名" 
                          required="required"
                          onclick="if(value==defaultValue){value='';this.style.color='#999'}" 
                          onBlur="if(!value){value=defaultValue;this.style.color='#999'}" 
                          />
                  
                     </div>
              </div>
              <!--输入密码***********************************************-->  
              <div style="width:400px">
                 <div class="text">
                       <font size="4" color="#999">密&nbsp;&nbsp;码</font>
                 </div>
                 <div class="input">
                   
                          <input type="text" name="password" class="rounded"
                          style="float:left"
                          placeholder="请输入6~16位数字和字母组成的密码" 
                          required="required"
                          pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$"
                          onclick="if(value==defaultValue){value='';this.style.color='#999'}" 
                          onBlur="if(!value){value=defaultValue;this.style.color='#999'}" 
                          />
                    
                </div>
            </div>
            
            <!--确认密码***********************************************-->
            <div style="width:400px">
                 <div class="text">
                       <font size="3" color="#999">确认密码</font>
                 </div>
                 <div class="input">
                    
                          <input type="text" name="repassword" class="rounded"
                          style="float:left"
                          placeholder="请输入上面输入的密码" 
                          required="required"
                          pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$"
                          onclick="if(value==defaultValue){value='';this.style.color='#999'}" 
                          onBlur="if(!value){value=defaultValue;this.style.color='#999'}" 
                          />
                    
                </div>
             </div>
            <!-- 提示信息%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% -->
            <div style="width:400px">
               <div style="float: left">
				 <font color="red" style="float: left"><s:fielderror/></font>
		        </div>
            </div>
             <div style="float:left">
                 <input value="重置" type="reset" name="zhuce" class="button ziti" />
             </div>
             <div style="float:left">
                 <input value="注册" type="submit" name="zhuce" class="button ziti" />
             </div> 
               </form>
             
     </div>
         
   </div>

</body>
</html>
