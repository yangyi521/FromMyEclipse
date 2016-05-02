<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
<title>修改用户信息</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
   <script>
	function checkuser(e,b){
		var name1=  e.value;
 if (name1 == ""||name1==null)      
  {   
  document.getElementById(b).innerHTML="<font color='red'>不能为空</font>";
  //.innerHTML="<p>用户名不能为空</p>" ;    
 // document.biandan1.tijiao.disabled=true;
  }else{
document.getElementById(b).innerHTML="  ";
}
	  }      

		function verifyEmail(email){
		var email = email.trim();
		var emailLength = email.length;
		if(emailLength < 6){
			msg = "邮箱地址必须5位以上";
			document.getElementById("mail1").innerHTML="<font color='red'>邮箱地址必须5位以上</font>";
			 //document.biandan1.tijiao.disabled=true;
		}else{
		var pattern = /^[a-zA-Z][a-zA-Z0-9_-]*@([a-zA-Z0-9_-]+.)+(com|gov|net|com.cn|edu.cn)$/;
		if(pattern.test(email)){
			document.getElementById("mail1").innerHTML="  ";
		}else{
			msg = "邮箱格式不正确";
			document.getElementById("mail1").innerHTML="<font color='red'>邮箱格式不正确</font>";
			 //document.biandan1.tijiao.disabled=true;
		}
		}
	}
	function trim(){
		var reSpace=/^\s*(.*?)\s*$/;
        return this.replace(reSpace,"$1");
    }
function IsDate(mystring,sm) {  
var reg = /^(\d{4})-(\d{2})-(\d{2})$/;  
var str = mystring;  
var arr = reg.exec(str);  
if (str==""){
	document.getElementById(sm).innerHTML="<font color='red'>不能为空</font>";
			 //document.biandan1.tijiao.disabled=true;
};  
if (!reg.test(str)&&RegExp.$2<=12&&RegExp.$3<=31){  
			document.getElementById(sm).innerHTML="<font color='red'>日期格式为yyyy-mm-dd</font>";
			 //document.biandan1.tijiao.disabled=true;
}else{
document.getElementById(sm).innerHTML="  ";
}
}  
function isInteger( str ,sm){  
var name1=  str;
 if (name1 == ""||name1==null)      
  {   
  document.getElementById(sm).innerHTML="<font color='red'>不能为空</font>";
  //.innerHTML="<p>用户名不能为空</p>" ;    
  //document.biandan1.tijiao.disabled=true;
  }else{
	  var regu = /^[-]{0,1}[0-9]{1,}$/; 
     if(regu.test(str)){
	document.getElementById(sm).innerHTML="  ";
}else{ 
document.getElementById(sm).innerHTML="<font color='red'>必须是数字</font>";
	//document.biandan1.tijiao.disabled=true;
	}; 
} 
}  
 

</script>
  
  <body>
    <div class="main">
	<div class="optitle clearfix">
		<div class="optitle clearfix">
	<em><input type="button" name="button" value="删除还书信息" class="input-button" onclick="location.href='ReturnBookListDelete.jsp'" /></em>
	    <em><input type="button" name="button" value="修改还书信息" class="input-button" onclick="location.href='ReturnBookListUpdate.jsp'" /></em>
	    <em><input type="button" name="button" value="查询还书信息" class="input-button" onclick="location.href='ReturnBookListDuery.jsp'" /></em>
		<em><input type="button" name="button" value="添加还书信息" class="input-button" onclick="location.href='ReturnBookListAdd.jsp'" /></em>
		<div class="title">还书信息&gt;&gt;</div>
	</div>
	
	<form method="post" action="ReturnBook?method=update">
	                    
	<div class="content">
			<table class="box">
			<tr>
					<td class="field">借阅ID：</td>
					<td><input type="text" name="reid" class="text" onblur="isInteger(this.value,'reid')"/><span id="reid"></span></td>
				</tr>
				<tr>
					<td class="field">ISBN：</td>
					<td><input type="text" name="isbn" class="text" onblur="isInteger(this.value,'ISBN')"/><span id="ISBN"></span></td>
				</tr>
				<tr>
					<td class="field">用户ID：</td>
					<td><input type="text" name="userid" class="text"onblur="isInteger(this.value,'userId')"/><span id="userId"></span></td>
				</tr>
				<tr>
					<td class="field">归回日期：</td>
					<td><input type="text" name="returntime" class="text" onblur="IsDate(this.value,'returntime')"/><span id="returntime"></span></td>
				</tr>
				<tr>
					<td class="field">借出状态：</td>
					<td><input type="text" name="condition" class="text" onblur="checkuser(this,'condition')"/><span id="condition"></span></td>
				</tr>
				<tr>
					
					<td></td>
				</tr>
				<tr>
                <td colspan="2"><span><%if(null!=request.getAttribute("info")){
				out.write(request.getAttribute("info").toString());
			}%></span></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="提交" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
  </body>
</html>
