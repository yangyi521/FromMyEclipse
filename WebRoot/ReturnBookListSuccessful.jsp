<%@page import="Bean.ReBookBean"%>
<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
    ReBookBean  book1=new ReBookBean(); 
    book1=(ReBookBean)request.getAttribute("info");
    request.setAttribute("book1",book1);
  %>
 
<div class="main">
	<div class="optitle clearfix">
	<em><input type="button" name="button" value="删除还书信息" class="input-button" onclick="location.href='ReturnBookListDelete.jsp'" /></em>
	    <em><input type="button" name="button" value="修改还书信息" class="input-button" onclick="location.href='ReturnBookListUpdate.jsp'" /></em>
	    <em><input type="button" name="button" value="查询还书信息" class="input-button" onclick="location.href='ReturnBookListDuery.jsp'" /></em>
		<em><input type="button" name="button" value="添加还书信息" class="input-button" onclick="location.href='ReturnBookListAdd.jsp'" /></em>
		<div class="title">还书信息&gt;&gt;</div>
	</div>
	<div class="content">
		<table class="list">
			<tr>
				<td>借阅ID</td>
				<td>ISBN</td>
				<td>用户id</td>
				<td>借阅时间</td>
				<td>借阅状态</td>
				
			</tr>
			
     		<tr>
     			<td>${book1.reid}</td>
				<td>${ book1.ISBN}</td>
				<td>${ book1.userid}</td>
				<td>${ book1.returnDate}</td>
				<td>${ book1.conditon}</td>
     		</tr>
				
		</table>
	</div>
</div>
</body>
</html>
