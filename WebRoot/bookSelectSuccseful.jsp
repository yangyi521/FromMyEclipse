<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page  import="DaoImpl.bookDaoImpl" %>
<%@ page  import="Bean.bookBean" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
   <title>所查图书</title>
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
    bookBean  user1=new bookBean();   
    user1=(bookBean)request.getAttribute("info");
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
		<div class="title">图书信息&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>ISBN</td>
				<td>书名</td>
				<td>作者</td>
				<td>出版时间</td>
				<td>简介</td>
				<td>数量</td>
			</tr>
			
			
     		<tr>
     			<td>${user1.ISBN}</td>
				<td>${ user1.bookName}</td>
				<td>${ user1.author}</td>
				<td>${user1.date}</td>
				<td>${ user1.catalog}</td>
				<td>${ user1.sum}</td>
     		</tr>
				
		</table>
	</div>
</div>
  </body>
</html>
