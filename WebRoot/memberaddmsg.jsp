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
<title>添加会员信息</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<script type="text/javascript">
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

function checkuser(e,b){
		var name1=  e.value;
 if (name1 == ""||name1==null)      
  {   
  document.getElementById(b).innerHTML="<font color='red'>不能为空</font>";
  //.innerHTML="<p>用户名不能为空</p>" ;    
 // document.biandan1.tijiao.disabled=true;
  }else{
	   var filter="^[0-9a-zA-Z\u4e00-\u9fa5]+$";    
 if (!filter.test(name1.value)) {
	
	document.getElementById(b).innerHTML="<font color='red'>填写不正确,请重新填写！</font>";
  //document.biandan1.tijiao.disabled=true;
}else{
document.getElementById(b).innerHTML="  ";
}
	  }      
 
  
		}
function checkEmail(strEmail,sm) { 
//var emailReg = /^[_a-z0-9]+@([_a-z0-9]+\.)+[a-z0-9]{2,3}$/; 
var emailReg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/; 
if( emailReg.test(strEmail) ){ 
document.getElementById(sm).innerHTML="  ";
}else{ 
document.getElementById(sm).innerHTML="<font color='red'>Email地址格式不正确</font>";
} 
} 

	</script>
<body>
<div class="main">
	<div class="optitle clearfix">
	    <em><input type="button" name="button" value="删除会员信息" class="input-button" onclick="location.href='memberdelmsg.jsp'" /></em>
	    <em><input type="button" name="button" value="修改会员信息" class="input-button" onclick="location.href='membermodifymsg.jsp'" /></em>
	    <em><input type="button" name="button" value="查询会员信息" class="input-button" onclick="location.href='memberquerymsg.jsp'" /></em>
		<em><input type="button" name="button" value="添加会员信息" class="input-button" onclick="location.href='memberaddmsg.jsp'" /></em>
		<div class="title">会员信息&gt;&gt;</div>
	</div>
	<form method="post" action="memberDal?method=add">
	<div class="content">
			<table class="box">
				
				<tr>
					<td class="field">会员姓名：</td>
					<td><input type="text" name="membername" class="text" onblur="checkuser(this,'membername')"/><span id="membername"></span></td>
				</tr>
				<tr>
					<td class="field">邮箱地址：</td>
					<td><input type="text" name="memberemil" class="text" onblur="checkEmail(this.value,'memberemil')"/><span id="memberemil"></span></td>
				</tr>
				<tr>
					<td class="field">联系电话：</td>
					<td><input type="text" name="telephone" class="text" onblur="isInteger(this.value,'telephone')"/><span id="telephone"></span></td>
				</tr>
				<tr>
					<td class="field">借阅数量：</td>
					<td><input type="text" name="getbook" class="text" onblur="isInteger(this.value,'getbook')"/><span id="getbook"></span></td>
				</tr>
				<tr>
                <td colspan="2"><span><%if(null!=request.getAttribute("info")){
				out.write(request.getAttribute("info").toString());
			}%></span></td>
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
