<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<title>酒水</title>
<link rel="stylesheet" type="text/css" href="../css/zhujiemian.css" />
<script LANGUAGE="JavaScript"> 
 
function openwin1() { 
  	window.open ("<%=path%>/goods/Win_winaddreflect", "", 
		"height=400,width=500,top=200,left=400,menubar=no,scrollbars=no,status=no")
	this.location="<%=path%>/goods/Vs_queryAllVs"
  } 
function openwin2(goodsname) { 
	  window.open ("<%=path%>/goods/Win_winmodifyreflect.action?goodsname="+goodsname, "", 
	"height=400,width=500,top=200,left=400,menubar=no,scrollbars=no,status=no")
	  } 
  function queren(str)
	{
	  var se=confirm("确认删除"+str+"吗!");
	  if (se==true){	
	 
		window.location.href='<%=path%>/goods/Win_delete.action?winname='+str; 
	  }
	}
  </script> 
</head>
<body>
    <div class="zuos">
          <div class="zsrentou">
                    <img src="../images/rentou.png" />
          </div>
          <div class="zsyonghu">
                    <font size="2">${sessionScope.loginUserName}</font><br />
                    <font size="+1">[</font><a href="<%=path %>/users/User_logout">退出</a>
                    <font size="+1">]</font>
            
          </div>
	 		
     </div>
     <div class="yous">
         <div class="sousuo">
              <img src="../images/sousuo.png" style="float:left;padding-right:10px;"/>
              <form  method="post" name="invest" style="float:left;" action="<%=path%>/goods/Search_search.action">
              <select name="search" style="height:30px;">
                  <option  selected="selected">菜表</option>
                  <option>酒水</option>
                  <option>配料</option>
                  <option>订单</option>
              </select>
              <input type="text" name="keyname" value="请输入查找的关键字"
                   style="height:25px;margin-left:5px;"  
                   onclick="if(value==defaultValue){value='';this.style.color='#999'}" 
                   onBlur="if(!value){value=defaultValue;this.style.color='#999'}" />
              <input type="submit" name="submit" value="搜索" style="height:30px;margin-left:5px;" />  
              </form>
         </div>
     
         <div class="ystime">
            <script type="text/javascript">
				var d=new Date();
				var date;
				var week;
				if(d.getDay()==0) week="星期日"
				if(d.getDay()==1) week="星期一"
				if(d.getDay()==2) week="星期二"
				if(d.getDay()==3) week="星期三"
				if(d.getDay()==4) week="星期四"
				if(d.getDay()==5) week="星期五"
				if(d.getDay()==6) week="星期六"
				date=(d.getFullYear())+"年"+(d.getMonth()+1)+"月"+(d.getDay())+"日"+" ";
				shijian=(d.getHours())+":"+(d.getMinutes());
				document.write("<span>"+date+week+shijian+"</span>");
			</script>
         </div>
     </div>
     <div class="zuox">
       <table width="148"  cellpadding="0" cellspacing="0" >
          <tr>
            <td height="40" align="center" valign="middle"background="../images/zitibeijing.png">                      
            <a href="<%=path%>/goods/Vs_queryAllVs"><strong>菜表</strong></a></td>
          </tr>
          <tr>
            <td height="40" align="center" valign="middle"background="../images/zitibeijing.png">                      
            <a href="<%=path%>/goods/Win_queryAllWin"><strong>酒水</strong></a></td>
          </tr>
          <tr>
            <td height="40" align="center" valign="middle"background="../images/zitibeijing.png">                       
            <a href="<%=path%>/goods/Ingredient_queryallin"><strong>配料</strong></a></td>
          </tr>
          <tr>
            <td height="40" align="center" valign="middle"background="../images/zitibeijing.png">                        
            <a href="<%=path%>/goods/Order_queryAllOrder"><strong>订单</strong></a></td>
          </tr>
          <tr>
            <td height="40" align="center" valign="middle"background="../images/zitibeijing.png">                       
            <a href="<%=path%>/goods/Finance_reflectfinance"><strong>财务</strong></a></td>
          </tr>
          
          <tr>
            <td height="40" align="center" valign="middle"background="../images/zitibeijing.png">                       
            <a href="<%=path%>/goods/VsIngredient_reflectvsin"><font color="#FF0000">菜与配料</font></a></td>
          </tr>
          
        </table>

     </div>
    
     <div class="youx">
         <div class="yxbiaoge">
        <form action="<%=path%>/goods/VsIngredient_addrelative" method="post" enctype="multipart/form-data" onsubmit="subform();">
       <table width="400" border="0"  cellspacing="0">
	        <tr>
	            <td height="40" valign="middle"><font color="#666666">菜名:</font></td>
	            <td valign="middle"><input type="text" name="vsname" required="required" /></td>
	        </tr> 
            
           <tr>
	            <td height="40" valign="middle"><font color="#666666">配料名:</font></td>
	            <td valign="middle"><input type="text" name="ingrename" required="required" /></td>
	        </tr> 
            
          <tr>
            <td height="47" valign="middle"> <font color="#666666">数量:</font></td>
            <td valign="middle"><input type="text" name="num" placeholder="请输入大于0的数字" required="required"/>
            	<input type="hidden" name="type" value="1"/>
            </td>
          </tr>
          
          <div class="anniu">
          <tr>
            <td height="55" align="center" valign="middle"><input type="reset" name="chongzhi" value="重置" /></td>
            <td align="center" valign="middle"><input type="submit" name="tijiao" value="提交" />  </td>
          </tr>
          </div>
          
        </table>
       <font color="red"> <s:fielderror/></font>
    </form>
       </div>
      
     </div>
     
</body>
</html>
