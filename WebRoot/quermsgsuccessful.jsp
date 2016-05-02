<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page  import="DaoImpl.MemberOperation" %>
<%@ page  import="Bean.MumberBean" %>
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
    MumberBean  user1=new MumberBean(); 
    user1=(MumberBean)request.getAttribute("info");
    request.setAttribute("user1",user1);
  %>
 <body>
   <div class="menu">
	
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='bookinsert.jsp'" /></em>
		<em><input type="button" name="button" value="修改数据" class="input-button" onclick="location.href='bookupdate.jsp'" /></em>
		<em><input type="button" name="button" value="删除数据" class="input-button" onclick="location.href='bookremove.jsp'" /></em>
		<em><input type="button" name="button" value="查找数据" class="input-button" onclick="location.href='bookselect.jsp'" /></em>
		<div class="title">会员信息&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>会员ID</td>
				<td>会员姓名</td>
				<td>邮箱地址</td>
				<td>联系方式</td>
				<td>借阅数量</td>
				
			</tr>
			
     		<tr>
     			<td>${user1.memberid}</td>
				<td>${ user1.membername}</td>
				<td>${ user1.memberemail}</td>
				<td>${ user1.telephone}</td>
				<td>${ user1.getbook}</td>
     		</tr>
				
		</table>
	</div>
</div>
</body>
</html>
