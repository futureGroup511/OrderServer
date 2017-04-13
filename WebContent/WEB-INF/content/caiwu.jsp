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
<title>财务</title>
<link rel="stylesheet" type="text/css" href="../css/zhujiemian.css" />
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
              <form  method="post" name="invest" style="float:left;"  action="<%=path%>/goods/Search_search.action">
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
            <a href="<%=path%>/goods/Finance_reflectfinance"><font color="#FF0000">财务</font></a></td>
          </tr>
          <tr>
            <td height="40" align="center" valign="middle"background="../images/zitibeijing.png">                       
            <a href="<%=path%>/goods/VsIngredient_reflectvsin"><strong>菜与配料</strong></a></td>
          </tr>
        </table>

     </div>
     <div class="youx">
         <div class="yxbiaoge">
         <form action="<%=path %>/finance/Finance_getFinance" method="post">
               <font color="#666666">按日期搜索</font>
                
                <input type="text" name="date" placeholder="查找的日期" 
           onclick="fPopCalendar(event,this,this)" 
           onfocus="this.select()" readonly="readonly" required="required" />
                   &nbsp;&nbsp;
                <input type="submit" name="chakan" value="查看" />
                <br /><br />
                <font color="#666666">总支出</font>&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text"name="zhichu"value="<s:property value="#request.pay"/>"onfocus="this.blur()"/>
                <br /><br />
                <font color="#666666">总收入</font>&nbsp;&nbsp;&nbsp;&nbsp;
                <input type="text"name="shouru"value="<s:property value="#request.income"/>"onfocus="this.blur()"/>
                <br /><br />
                <font color="#666666">单日获利</font>&nbsp;&nbsp;
                <input type="text"name="huoli"value="<s:property value="#request.profit"/>"onfocus="this.blur()"/>
              </form>  
         </div>
       
     </div>
<script type="text/javascript">
var gMonths=new Array("一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月");
var WeekDay=new Array("日","一","二","三","四","五","六");
var strToday="今天";
var strYear="年";
var strMonth="月";
var strDay="日";
var splitChar="-";
var startYear=2000;
var endYear=2050;
var dayTdHeight=12;
var dayTdTextSize=12;
var gcNotCurMonth="#E0E0E0";
var gcRestDay="#FF0000";
var gcWorkDay="#444444";
var gcMouseOver="#79D0FF";
var gcMouseOut="#F4F4F4";
var gcToday="#444444";
var gcTodayMouseOver="#6699FF";
var gcTodayMouseOut="#79D0FF";
var gdCtrl=new Object();
var goSelectTag=new Array();
var gdCurDate=new Date();
var giYear=gdCurDate.getFullYear();
var giMonth=gdCurDate.getMonth()+1;
var giDay=gdCurDate.getDate();
function $(){var elements=new Array();for(var i=0;i<arguments.length;i++) {var element=arguments[i];if(typeof(arguments[i])=='string'){element=document.getElementById(arguments[i]);}if(arguments.length==1){return element;}elements.Push(element);}return elements;}
Array.prototype.Push=function(){var startLength=this.length;for(var i=0;i<arguments.length;i++){this[startLength+i]=arguments[i];}return this.length;}
String.prototype.HexToDec=function(){return parseInt(this,16);}
String.prototype.cleanBlank=function(){return this.isEmpty()?"":this.replace(/\s/g,"");}
function checkColor(){var color_tmp=(arguments[0]+"").replace(/\s/g,"").toUpperCase();var model_tmp1=arguments[1].toUpperCase();var model_tmp2="rgb("+arguments[1].substring(1,3).HexToDec()+","+arguments[1].substring(1,3).HexToDec()+","+arguments[1].substring(5).HexToDec()+")";model_tmp2=model_tmp2.toUpperCase();if(color_tmp==model_tmp1 ||color_tmp==model_tmp2){return true;}return false;}
function $V(){return $(arguments[0]).value;}
function fPopCalendar(evt,popCtrl,dateCtrl){evt.cancelBubble=true;gdCtrl=dateCtrl;fSetYearMon(giYear,giMonth);var point=fGetXY(popCtrl);with($("calendardiv").style){left=point.x+"px";top=(point.y+popCtrl.offsetHeight+1)+"px";visibility='visible';zindex='99';position='absolute';}$("calendardiv").focus();}
function fSetDate(iYear,iMonth,iDay){var iMonthNew=new String(iMonth);var iDayNew=new String(iDay);if(iMonthNew.length<2){iMonthNew="0"+iMonthNew;}if(iDayNew.length<2){iDayNew="0"+iDayNew;}gdCtrl.value=iYear+splitChar+iMonthNew+splitChar+iDayNew;fHideCalendar();}
function fHideCalendar(){$("calendardiv").style.visibility="hidden";for(var i=0;i<goSelectTag.length;i++){goSelectTag[i].style.visibility="visible";}goSelectTag.length=0;}
function fSetSelected(){var iOffset=0;var iYear=parseInt($("tbSelYear").value);var iMonth=parseInt($("tbSelMonth").value);var aCell=$("cellText"+arguments[0]);aCell.bgColor=gcMouseOut;with(aCell){var iDay=parseInt(innerHTML);if(checkColor(style.color,gcNotCurMonth)){iOffset=(innerHTML>10)?-1:1;}iMonth+=iOffset;if(iMonth<1){iYear--;iMonth=12;}else if(iMonth>12){iYear++;iMonth=1;}}fSetDate(iYear,iMonth,iDay);}
function Point(iX,iY){this.x=iX;this.y=iY;}
function fBuildCal(iYear,iMonth){var aMonth=new Array();for(var i=1;i<7;i++){aMonth[i]=new Array(i);}var dCalDate=new Date(iYear,iMonth-1,1);var iDayOfFirst=dCalDate.getDay();var iDaysInMonth=new Date(iYear,iMonth,0).getDate();var iOffsetLast=new Date(iYear,iMonth-1,0).getDate()-iDayOfFirst+1;var iDate=1;var iNext=1;for(var d=0;d<7;d++){aMonth[1][d]=(d<iDayOfFirst)?(iOffsetLast+d)*(-1):iDate++;}for(var w=2;w<7;w++){for(var d=0;d<7;d++){aMonth[w][d]=(iDate<=iDaysInMonth)?iDate++:(iNext++)*(-1);}}return aMonth;}
function fDrawCal(iYear,iMonth,iCellHeight,iDateTextSize){var colorTD=" bgcolor='"+gcMouseOut+"' bordercolor='"+gcMouseOut+"'";var styleTD=" valign='middle' align='center' style='height:"+iCellHeight+"px;font-weight:bolder;font-size:"+iDateTextSize+"px;";var dateCal="";dateCal+="<tr>";for(var i=0;i<7;i++){dateCal+="<td"+colorTD+styleTD+"color:#990099'>"+WeekDay[i]+"</td>";}dateCal+="</tr>";for(var w=1;w<7;w++){dateCal+="<tr>";for(var d=0;d<7;d++){var tmpid=w+""+d;dateCal+="<td"+styleTD+"cursor:pointer;' onclick='fSetSelected("+tmpid+")'>";dateCal+="<span id='cellText"+tmpid+"'></span>";dateCal+="</td>";}dateCal+="</tr>";}return dateCal;}
function fUpdateCal(iYear,iMonth){var myMonth=fBuildCal(iYear,iMonth);var i=0;for(var w=1;w<7;w++){for(var d=0;d<7;d++){with($("cellText"+w+""+d)){parentNode.bgColor=gcMouseOut;parentNode.borderColor=gcMouseOut;parentNode.onmouseover=function(){this.bgColor=gcMouseOver;};parentNode.onmouseout=function(){this.bgColor=gcMouseOut;};if(myMonth[w][d]<0){style.color=gcNotCurMonth;innerHTML=Math.abs(myMonth[w][d]);}else{style.color=((d==0)||(d==6))?gcRestDay:gcWorkDay;innerHTML=myMonth[w][d];if(iYear==giYear && iMonth==giMonth && myMonth[w][d]==giDay){style.color=gcToday;parentNode.bgColor=gcTodayMouseOut;parentNode.onmouseover=function(){this.bgColor=gcTodayMouseOver;};parentNode.onmouseout=function(){this.bgColor=gcTodayMouseOut;};}}}}}}
function fSetYearMon(iYear,iMon){$("tbSelMonth").options[iMon-1].selected=true;for(var i=0;i<$("tbSelYear").length;i++){if($("tbSelYear").options[i].value==iYear){$("tbSelYear").options[i].selected=true;}}fUpdateCal(iYear,iMon);}
function fPrevMonth(){var iMon=$("tbSelMonth").value;var iYear=$("tbSelYear").value;if(--iMon<1){iMon=12;iYear--;}fSetYearMon(iYear,iMon);}
function fNextMonth(){var iMon=$("tbSelMonth").value;var iYear=$("tbSelYear").value;if(++iMon>12){iMon=1;iYear++;}fSetYearMon(iYear,iMon);}
function fGetXY(aTag){var oTmp=aTag;var pt=new Point(0,0);do{pt.x+=oTmp.offsetLeft;pt.y+=oTmp.offsetTop;oTmp=oTmp.offsetParent;}while(oTmp.tagName.toUpperCase()!="BODY");return pt;}
function getDateDiv(){var noSelectForIE="";var noSelectForFireFox="";if(document.all){noSelectForIE="onselectstart='return false;'";}else{noSelectForFireFox="-moz-user-select:none;";}var dateDiv="";dateDiv+="<div id='calendardiv' onclick='event.cancelBubble=true' "+noSelectForIE+" style='"+noSelectForFireFox+"position:absolute;z-index:99;visibility:hidden;border:1px solid #999999;'>";dateDiv+="<table border='0' bgcolor='#E0E0E0' cellpadding='1' cellspacing='1' >";dateDiv+="<tr>";dateDiv+="<td><input type='button' id='PrevMonth' value='<' style='height:20px;width:20px;font-weight:bolder;' onclick='fPrevMonth()'>";dateDiv+="</td><td><select id='tbSelYear' style='border:1px solid;' onchange='fUpdateCal($V(\"tbSelYear\"),$V(\"tbSelMonth\"))'>";for(var i=startYear;i<endYear;i++){dateDiv+="<option value='"+i+"'>"+i+strYear+"</option>";}dateDiv+="</select></td><td>";dateDiv+="<select id='tbSelMonth' style='border:1px solid;' onchange='fUpdateCal($V(\"tbSelYear\"),$V(\"tbSelMonth\"))'>";for(var i=0;i<12;i++){dateDiv+="<option value='"+(i+1)+"'>"+gMonths[i]+"</option>";}dateDiv+="</select></td><td>";dateDiv+="<input type='button' id='NextMonth' value='>' style='height:20px;width:20px;font-weight:bolder;' onclick='fNextMonth()'>";dateDiv+="</td>";dateDiv+="</tr><tr>";dateDiv+="<td align='center' colspan='4'>";dateDiv+="<div style='background-color:#cccccc'><table width='100%' border='0' cellpadding='3' cellspacing='1'>";dateDiv+=fDrawCal(giYear,giMonth,dayTdHeight,dayTdTextSize);dateDiv+="</table></div>";dateDiv+="</td>";dateDiv+="</tr><tr><td align='center' colspan='4' nowrap>";dateDiv+="<span style='cursor:pointer;font-weight:bolder;' onclick='fSetDate(giYear,giMonth,giDay)' onmouseover='this.style.color=\""+gcMouseOver+"\"' onmouseout='this.style.color=\"#000000\"'>"+strToday+":"+giYear+strYear+giMonth+strMonth+giDay+strDay+"</span>";dateDiv+="</tr></tr>";dateDiv+="</table></div>";return dateDiv;}
with(document){onclick=fHideCalendar;write(getDateDiv());}
</script>

</body>
</html>
