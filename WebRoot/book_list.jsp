<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
   <title>所有图书</title>
   <link type="text/css" rel="stylesheet" href="css/style.css" />
    
    
    <title>My JSP 'book_list.jsp' starting page</title>
    
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
    bookDaoImpl ab=new bookDaoImpl();
    List<bookBean> list=ab.getAll();
    request.setAttribute("list",list);
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
				<td>时间</td>
				<td>简介</td>
				<td>总数</td>
				
			</tr>
			
			<c:forEach var="user1" items="${list }">
     		<tr>
     			<td>${user1.ISBN}</td>
				<td>${ user1.bookName}</td>
				<td>${ user1.author}</td>
				<td>${user1.date}</td>
				<td>${ user1.catalog}</td>
				<td>${ user1.sum}</td>
     		</tr>
     		</c:forEach>
				
		</table>
	</div>
</div>
  </body>
</html>
