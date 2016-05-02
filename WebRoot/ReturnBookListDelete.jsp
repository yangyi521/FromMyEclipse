<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>删除会员信息</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
 <script>
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
<em><input type="button" name="button" value="删除还书信息" class="input-button" onclick="location.href='ReturnBookListDelete.jsp'" /></em>
	    <em><input type="button" name="button" value="修改还书信息" class="input-button" onclick="location.href='ReturnBookListUpdate.jsp'" /></em>
	    <em><input type="button" name="button" value="查询还书信息" class="input-button" onclick="location.href='ReturnBookListDuery.jsp'" /></em>
		<em><input type="button" name="button" value="添加还书信息" class="input-button" onclick="location.href='ReturnBookListAdd.jsp'" /></em>
		<div class="title">还书信息&gt;&gt;</div>
	</div>
	<form method="post" action="ReturnBook?method=delete">
	<div class="content">
			<table class="box">
				<tr>
					<td class="field">借阅ID：</td>
					<td><input type="text" name="reid" class="text" onblur="isInteger(this.value,'reid')"/><span id="reid"></span></td>
				</tr>
				
				<tr>
                <td colspan="2">
                    <span>
                <%if(null!=request.getAttribute("info")){
				       out.write(request.getAttribute("info").toString());
			     }%>
			       </span></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="确认删除" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
  </body>
</html>
