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
   <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有图书</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
  </head>
   <% 
    Borrowbooks  user1=new Borrowbooks();   
    LoanLogDaoImpl ab=new LoanLogDaoImpl();
    List<Borrowbooks> list=ab.getAll();
    request.setAttribute("list",list);
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
				<c:forEach var="user1" items="${list }"><!-- 增强循环 -->
     		<tr>
     			<td>${user1.getId}</td><!--  -->
     			<td>${user1.userId}</td><!--  -->
				<td>${ user1.ISBN}</td>
				<td>${ user1.userName}</td>
				<td>${ user1.bookName}</td>
				<td>${ user1.getDate}</td>
				<td>${ user1.condition}</td>
     		</tr>
     		</c:forEach>
       </table>
	</div>
</div>
  </body>
</html>
