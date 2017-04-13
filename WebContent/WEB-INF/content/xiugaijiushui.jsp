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
<title>修改酒水</title>
<link rel="stylesheet" type="text/css" href="../css/tianjia.css" />

	
	<script language="JavaScript">
		
		
		function subform(){
		   	
		     window.close();//关闭窗口
		   	 window.opener.location.reload(); 
		    <%-- //window.opener.location.href='<%=path%>/goods/Vs_queryAllVs'; --%>
		   /* 	window.opener.location.href = window.opener.location.href;
		    window.close();   */
		    
		 } 
		
		
	</script>
	
	


</head>
<body onunload="window.opener.location.reload();">
   <div class="box">
        <div class="xinxi">
     <form action="<%=path%>/goods/Win_winmodify" method="post"  onsubmit="subform();">
            <table width="400" border="0" cellspacing="0">
  <tr>
    <td height="39" valign="middle"><font color="#666666">酒名</font></td>
    <td valign="middle"><input type="text"name="goodsname" placeholder="当前菜名"onfocus="this.blur()" value="${requestScope.win.goodsname }"/></td>
  </tr>
  <%-- <tr>
    <td height="42" valign="middle"><font color="#666666">图片</font></td>
    <td valign="middle"><input type="file" name="tupian" placeholder="当前图片" required="required" value="${requestScope.vegetable.goodsname }"/></td>
  </tr> --%>
  <tr>
    <td height="31" valign="middle"><font color="#666666">价格</font></td>
    <td valign="middle"><input type="text" name="price" placeholder="当前价格" title="只能输入数字"
           required="required"  pattern="^[0-9]*$" value="${requestScope.win.price }"/></td>
  </tr>
  <tr>
    <td height="59" valign="middle"><font color="#666666">详细描述</font></td>
    <td valign="middle"><textarea name="goodsdesc" style="height:40px;" placeholder="当前详细描述" >${requestScope.win.goodsdesc }</textarea></td>
  </tr>
  <div class="anniu">
  <tr>
    <td height="47" align="center" valign="middle"><input type="reset" name="chongzhi" value="重置" /></td>
    <td align="center" valign="middle"><input type="submit"name="tijiao" value="修改" />  </td>
  </tr>
  </div>
</table>
</form>
 
        </div>
   </div>

</body>
</html>
