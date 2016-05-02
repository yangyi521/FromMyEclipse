<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
   <title>查询信息</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
   <script>
  function isInteger( str ,sm){  
var name1=  str;
 if (name1 == ""||name1==null)      
  {   
  document.getElementById(sm).innerHTML="<font color='red'>不能为空</font>";
  //.innerHTML="<p>用户名不能为空</p>" ;    
  //document.biandan1.tijiao.disabled=true;
  }else{
	  var regu = /^[-]{0,1}[0-9]{1,}$/; 
     if(regu.test(str)){
	document.getElementById(sm).innerHTML="  ";
}else{ 
document.getElementById(sm).innerHTML="<font color='red'>必须是数字</font>";
	//document.biandan1.tijiao.disabled=true;
	}; 
} 
}  
  </script>
  <body>
    <div class="menu">
	
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='bookinsert.jsp'" /></em>
		<em><input type="button" name="button" value="修改数据" class="input-button" onclick="location.href='bookupdate.jsp'" /></em>
		<em><input type="button" name="button" value="删除数据" class="input-button" onclick="location.href='bookremove.jsp'" /></em>
		<em><input type="button" name="button" value="查找数据" class="input-button" onclick="location.href='bookselect.jsp'" /></em>
		<div class="title">图书管理&gt;&gt;</div>
	</div>
	<form method="post" action="bookDal?method=select">
	<div class="content">
			<table class="box">
			<tr>
					<td class="field">查询ISBN号：</td>
					<td><input type="text" name="ISBN" class="text" onblur="isInteger(this.value,'ISBN')"/><span id="ISBN"></span></td>
				</tr>
				
				<tr>
                <td colspan="2"><span><%if(null!=request.getAttribute("info")){
				out.write(request.getAttribute("info").toString());
			}%></span></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="提交" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
  </body>
</html>
