<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>系统登录 - 图书管理系统</title>
    <link type="text/css" rel="stylesheet" href="css/style.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body class="blue-style">
<div id="login">
	<div class="icon"></div>
	<div class="login-box">
		<form method="post" action="Check">
			<dl>
				<dt>用户名：</dt>
				<dd><input type="text" name="account" class="input-text" /><span><font color="red"><%if(null!=request.getAttribute("info")){
				out.write(request.getAttribute("info").toString());
			}%></font></span></dd>
				<dt>密　码：</dt>
				<dd><input type="password" name="password" class="input-text" /></dd>
				
			</dl>
			<div class="buttons">
				<input type="submit" name="submit" value="登录系统" class="input-button" />
				<input type="reset" name="reset" value="重　　置" class="input-button" />
			</div>
		</form>
	</div>
</div>
</body>
</html>
