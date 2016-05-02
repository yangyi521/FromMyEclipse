<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page  import="DaoImpl.MemberOperation" %>
<%@ page  import="Bean.MumberBean" %>
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
    MumberBean  user1=new MumberBean();   
    MemberOperation ab=new MemberOperation();
    List<MumberBean> list=ab.showall();
    request.setAttribute("list",list);
   %>
   
   
  <body>
  <div class="menu">
	
</div>
<div class="main">
	<div class="optitle clearfix">
	    <em><input type="button" name="button" value="删除会员信息" class="input-button" onclick="location.href='memberdelmsg.jsp'" /></em>
	    <em><input type="button" name="button" value="修改会员信息" class="input-button" onclick="location.href='membermodifymsg.jsp'" /></em>
	    <em><input type="button" name="button" value="查询会员信息" class="input-button" onclick="location.href='memberquerymsg.jsp'" /></em>
		<em><input type="button" name="button" value="添加会员信息" class="input-button" onclick="location.href='memberaddmsg.jsp'" /></em>
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
				<c:forEach var="user1" items="${list }"><!-- 增强循环 -->
     		<tr>
     			<td>${user1.memberid}</td><!--  -->
				<td>${ user1.membername}</td>
				<td>${ user1.memberemail}</td>
				<td>${ user1.telephone}</td>
				<td>${ user1.getbook}</td>
     		</tr>
     		</c:forEach>
       </table>
	</div>
</div>
  </body>
</html>