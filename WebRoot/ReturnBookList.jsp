<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="DaoImpl.ReBookDaoImpl"%>
<%@page import="Dao.ReBookDao"%>
<%@page import="Bean.ReBookBean"%>
<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>所有会员</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
 <% 
    ReBookBean  rebook =new ReBookBean();   
    ReBookDaoImpl  diao=new  ReBookDaoImpl();
    List<ReBookBean> list=diao.getAll();
    request.setAttribute("list",list);
   %>
   
   
  <body>
  <div class="menu">
	
</div>
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
				<td>会员号</td>
				<td>还书日期</td>
				<td>图书状态</td>
				
			</tr>
				<c:forEach var="rebook" items="${list }"><!-- 增强循环 -->
     		<tr>
     			<td>${rebook.reid}</td><!--  -->
				<td>${ rebook.ISBN}</td>
				<td>${ rebook.userid}</td>
				<td>${ rebook.returnDate}</td>
				<td>${ rebook.conditon}</td>
     		</tr>
     		</c:forEach>
       </table>
	</div>
</div>
  </body>
</html>