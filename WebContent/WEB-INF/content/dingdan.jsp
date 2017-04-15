<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>订单</title>
<link rel="stylesheet" type="text/css" href="../css/zhujiemian.css" />
<script LANGUAGE="JavaScript"> 

  function openwin2(str1,str2) { 
  window.open ("<%=path%>/goods/Order_ordermodifyreflect.action?tablenum="+str1+"&datetime="+str2, "", 
"height=400,width=500,top=200,left=400,menubar=no,scrollbars=no,status=no")
  } 
  function queren(str1,str2)
	{
	  var se=confirm("确认删除"+str1+str2+"吗!");
	  if (se==true){	
	 
		window.location.href='<%=path%>/goods/Order_deleteOrder.action?tablenum='+str1+'&datetime='+str2; 
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
            <a href="<%=path%>/goods/Order_queryAllOrder"><font color="#FF0000">订单</font></a></td>
          </tr>         
          <tr>
            <td height="40" align="center" valign="middle"background="../images/zitibeijing.png">                       
            <a href="<%=path%>/goods/VsIngredient_reflectvsin"><strong>菜与配料</strong></a></td>
          </tr>
        </table>

     </div>
     <div class="youx">
         <div class="yxbiaoge">
         	<div>
         		<form action="${pageContext.request.contextPath }/Order_searchOrderByDate" method="post">
         			起始日期：<input type="date" name="start"/>
         			截止日期：<input type="date" name="end"/>
         			<input type="submit" value="搜索">
         		</form>
         		
         	</div>
         	<br>
         <table width="700" border="1" cellpadding="0" cellspacing="0" >
           <tr>
                <td height="50" colspan="5" align="center" valign="middle" bgcolor="#7CB2D3">订单详细信息</td>
              </tr>
              <tr align="left" valign="middle"  style="background:#E3E3E3">
               <!--  <td width="76" height="30">选择</td> -->
                <td width="175" height="30">桌号</td>
                <td width="136" height="30">总价</td>
                <td width="165" height="30">时间</td>
                <td width="136" height="30">操作</td>
           </tr>
           
           <s:iterator value="#request.allorder" var="order">
              <tr>
               <!--  <td height="30"><input type="checkbox" name="xuanze" /></td> -->
                <td height="30"><s:property value="#order.tablenum"/></td>
                <td height="30"><s:property value="#order.ordercount"/></td>
                <td height="30"><fmt:formatDate type="both" 
            dateStyle="medium" timeStyle="medium" 
            value="${ order.orderdate}" /></td>               
                <td height="30"><input type="button" onclick="queren('<s:property value="#order.tablenum"/>','<s:property value="#order.orderdate"/>')" value="删除" />
                <input type="button" name="xiugai" onclick="openwin2('<s:property value="#order.tablenum"/>','<s:property value="#order.orderdate"/>')" value="修改"/></td>
           	 </tr>
           </s:iterator>
           </table>
       </div>

       
       <div class="yxdz">
            <p>该页面总收入：${sum }（元）</p>           
       </div> 
        <c:if test="${search!='search'}">
	       <div class="yxdy">          
	            <a href="${pageContext.request.contextPath }/goods/Order_page?number=3">首页</a>&nbsp;|
	            <a href="${pageContext.request.contextPath }/goods/Order_page?number=1">上一页</a>&nbsp;|
	            <a href="${pageContext.request.contextPath }/goods/Order_page?number=2">下一页</a>&nbsp;|          
	       </div>
     	</c:if>

     
     
</div>


</body>
</html>
