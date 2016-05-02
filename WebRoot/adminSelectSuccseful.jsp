<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  import="DaoImpl.adminDaoImpl" %>
<%@ page  import="Bean.adminBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>所有用户</title>
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
 <% 
    adminBean  user1=new adminBean();   
    user1=(adminBean)request.getAttribute("info");
    request.setAttribute("user1",user1);
   %>
<body>
<div class="menu">
	
</div>
<div class="main">
	<div class="optitle clearfix">
				<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='adminAdd.jsp'" /></em>
		<em><input type="button" name="button" value="修改数据" class="input-button" onclick="location.href='adminUpdate.jsp'" /></em>
		<em><input type="button" name="button" value="删除数据" class="input-button" onclick="location.href='adminRemove.jsp'" /></em>
		<em><input type="button" name="button" value="查找数据" class="input-button" onclick="location.href='adminSelect.jsp'" /></em>
		<div class="title">用户信息&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>用户名</td>
				<td>密码</td>
				<td>权限</td>
				
			</tr>
			
			
     		<tr>
     			<td>${user1.userName}</td>
				<td>${ user1.passWrod}</td>
				<td>${ user1.power}</td>
     		</tr>
				
		</table>
	</div>
</div>
</body>
</html>
