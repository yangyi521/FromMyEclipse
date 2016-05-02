<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
  <title>修改信息</title>
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
  <script>
	function checkuser(e,b){
		var name1=  e.value;
 if (name1 == ""||name1==null)      
  {   
  document.getElementById(b).innerHTML="<font color='red'>不能为空</font>";
  //.innerHTML="<p>用户名不能为空</p>" ;    
  //document.biandan1.tijiao.disabled=true;
  }else{
	   var filter=/^\s*[.A-Za-z0-9_-]{6,20}\s*$/;   
 if (!filter.test(name1.value)) {
	
	document.getElementById(b).innerHTML="<font color='red'>填写不正确,请重新填写！</font>";
  //document.biandan1.tijiao.disabled=true;
}else{
document.getElementById(b).innerHTML="  ";
}
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
			// document.biandan1.tijiao.disabled=true;
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
     <div class="menu">
	
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='bookinsert.jsp'" /></em>
		<em><input type="button" name="button" value="修改数据" class="input-button" onclick="location.href='bookupdate.jsp'" /></em>
		<em><input type="button" name="button" value="删除数据" class="input-button" onclick="location.href='bookremove.jsp'" /></em>
		<em><input type="button" name="button" value="查找数据" class="input-button" onclick="location.href='bookselect.jsp'" /></em>
		<div class="title">图书管理&gt;&gt;</div>
	</div>
	<form method="post" action="bookDal?method=update">
	<div class="content">
			<table class="box">
			<tr>
					<td class="field">旧的ISBN：</td>
					<td><input type="text" name="oISBN" class="text" onblur="isInteger(this.value,'oISBN')"/><span id="oISBN"></span></td>
				</tr>
				<tr>
					<td class="field">更改ISBN：</td>
					<td><input type="text" name="ISBN" class="text" onblur="isInteger(this.value,'ISBN')"/><span id="ISBN"></span></td>
				</tr>
				
				<tr>
					<td class="field">图书名：</td>
					<td><input type="text" name="bookName" class="text" onblur="checkuser(this,'bookName')"/><span id="bookName"></span></td>
				</tr>
				<tr>
					<td class="field">作者：</td>
					<td><input type="text" name="author" class="text" onblur="checkuser(this,'author')"/><span id="author"></span></td>
				</tr>
				<tr>
					<td class="field">出版时间：</td>
					<td><input type="text" name="date" class="text" onblur="IsDate(this.value,'date')"/><span id="date"></span></td>
				</tr>
				<tr>
					<td class="field">简介：</td>
					<td><input type="text" name="catalog" class="text" onblur="checkuser(this,'catalog')"/><span id="catalog"></span></td>
				</tr>
				<tr>
					<td class="field">总数：</td>
					<td><input type="text" name="sum" class="text" onblur="isInteger(this.value,'sum')"/><span id="sum"></span></td>
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
