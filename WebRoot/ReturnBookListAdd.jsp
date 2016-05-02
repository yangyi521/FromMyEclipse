<%@ page language="java" import="java.util.*"  pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加还书信息</title>
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
	  <em><input type="button" name="button" value="删除还书信息" class="input-button" onclick="location.href='ReturnBookListDelete.jsp'" /></em>
	    <em><input type="button" name="button" value="修改还书信息" class="input-button" onclick="location.href='ReturnBookListUpdate.jsp'" /></em>
	    <em><input type="button" name="button" value="查询还书信息" class="input-button" onclick="location.href='ReturnBookListDuery.jsp'" /></em>
		<em><input type="button" name="button" value="添加还书信息" class="input-button" onclick="location.href='ReturnBookListAdd.jsp'" /></em>
		<div class="title">还书信息&gt;&gt;</div>
	</div>
	<form method="post" action="ReturnBook?method=add">
	<div class="content">
			<table class="box">
				<tr>
					<td class="field">借阅单号：</td>
					<td><input type="text" name="getid" class="text" onblur="isInteger(this.value,'getid')"/><span id="getid"></span></td>
				</tr>
				<tr>
					<td class="field">借阅状态：</td>
					<td><input type="text" name="condition" class="text" value="已归还" onblur="checkuser(this,'condition')"/><span id="condition"></span></td>
				</tr>
				<tr>
                <td colspan="2"><span><font color="red"><%if(null!=request.getAttribute("info")){
				out.write(request.getAttribute("info").toString());
			}%></font></span></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="确认添加" class="input-button" />
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>

  </body>
</html>
