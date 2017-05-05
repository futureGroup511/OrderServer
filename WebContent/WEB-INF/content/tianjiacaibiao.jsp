<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html >
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加新菜</title>
<link rel="stylesheet" type="text/css" href="../css/tianjia.css" />

	<script language="JavaScript">
		
		
		function subform(){
			
			
			// document.getElementById("f").submit();	onunload="window.opener.location.reload();"
		     window.close();//关闭窗口
		   	 window.opener.location.reload(); 
		    	   
		 } 
		
	</script>

</head>

<body >			
    <div class="box">
       <div class="xinxi">
       <form id="f" name="f" action="<%=path%>/goods/Upload_uploadvs" method="post"  enctype="multipart/form-data" >
       <table width="400" border="0"  cellspacing="0">
	        <tr>
	            <td height="40" valign="middle"><font color="#666666">菜名:</font></td>
	            <td valign="middle"><input type="text" name="goodsname" required="required" /></td>
	        </tr> 
          
          <s:file name="upload" label="图片"/>
          
          <tr>
            <td height="47" valign="middle"> <font color="#666666">价格:</font></td>
            <td valign="middle"><input type="text" name="price" placeholder="请输入大于0的数字" required="required"/>
            	<input type="hidden" name="type" value="1"/>
            </td>
          </tr>
         <tr>
            <td valign="middle"> <font color="#666666">详细描述:</font></td>
            <td valign="middle"><textarea name="goodsdesc" style="height:40px;" required="required"></textarea></td>
          </tr>
          
          <div class="anniu">
          <tr>
            <td height="55" align="center" valign="middle"><input type="reset"  value="重置" /></td>
            <td align="center" valign="middle"><input type="submit"   value="提交" />  </td>
          </tr>
          </div>
          
        </table>
        
    </form>
    </div>
    </div>
      
</body>
</html>
