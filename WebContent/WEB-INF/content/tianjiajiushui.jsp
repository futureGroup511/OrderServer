<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加新酒</title>
<link rel="stylesheet" type="text/css" href="../css/tianjia.css" />

	<script language="JavaScript">
		
		
		function subform(){
		   	
			 window.opener.location.reload(); 
		     window.close();//关闭窗口
		   	
		    <%-- //window.opener.location.href='<%=path%>/goods/Vs_queryAllVs'; --%>
		   /* 	window.opener.location.href = window.opener.location.href;
		    window.close();   */
		    
		 } 
		
		
	</script>



</head>

<body onunload="window.opener.location.reload();">
   <div class="box">
       <div class="xinxi">
       <form action="<%=path%>/goods/Upload_uploadvs" method="post" enctype="multipart/form-data"  onsubmit="subform();">
       <table width="400" border="0"  cellspacing="0">
          <tr>
            <td height="40" valign="middle"><font color="#666666">酒名</font></td>
            <td valign="middle"><input type="text" name="goodsname" required="required" /></td>
          </tr>
          
           <s:file name="upload" label="图片"/>
          
          <tr>
            <td height="47" valign="middle"> <font color="#666666">价格</font></td>
            <td valign="middle"><input type="text" name="price" placeholder="请输入大于0的数字" required="required"/> 
            	<input type="hidden" name="type" value="2"/>
            </td>
          </tr>
          <tr>
            <td valign="middle"> <font color="#666666">详细描述</font></td>
            <td valign="middle"><textarea name="goodsdesc" style="height:40px;" required="required"></textarea></td>
          </tr>
          <div class="anniu">
          <tr>
            <td height="55" align="center" valign="middle"><input type="reset" name="chongzhi" value="重置" /></td>
            <td align="center" valign="middle"><input type="submit"name="tijiao" value="提交" />  </td>
          </tr>
          </div>
        </table>
    </form>
    </div>
    </div>
    

</body>
</html>
