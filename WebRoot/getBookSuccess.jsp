<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page  import="DaoImpl.LoanLogDaoImpl" %>
<%@ page  import="Bean. Borrowbooks" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'getBookSuccess.jsp' starting page</title>
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
   <% 
     Borrowbooks  user1=new  Borrowbooks();   
    user1=( Borrowbooks)request.getAttribute("info");
    request.setAttribute("user1",user1);
   %>
   <body>
   <div class="menu">
	
</div>
<div class="main">
	<div class="optitle clearfix">
         <em><input type="button" name="button" value="添加借书信息" class="input-button" onclick="location.href='getBookAdd.jsp'" /></em>
		<em><input type="button" name="button" value="修改借书信息" class="input-button" onclick="location.href='getBookUpdate.jsp'" /></em>
		<em><input type="button" name="button" value="删除借书信息" class="input-button" onclick="location.href='getBookRemove.jsp'" /></em>
		<em><input type="button" name="button" value="查找借书信息" class="input-button" onclick="location.href='getBookSelect.jsp'" /></em>
		<div class="title">书籍借阅&gt;&gt;</div>
		<div class="title">借阅信息&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
			    <td>借书单号</td>
				<td>会员id</td>
				<td>ISBN</td>
				<td>会员姓名</td>
				<td>图书名字</td>
				<td>借书时间</td>
				<td>状态</td>
				
			</tr>			
     		<tr>
     			<td>${user1.getId}</td><!--  -->
     			<td>${user1.userId}</td><!--  -->
				<td>${ user1.ISBN}</td>
				<td>${ user1.userName}</td>
				<td>${ user1.bookName}</td>
				<td>${ user1.getDate}</td>
				<td>${ user1.condition}</td>
     		</tr>		
       </table>
	</div>
</div>
  </body>
</html>
