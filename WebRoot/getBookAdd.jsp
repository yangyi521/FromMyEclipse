<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加图书</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
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

	</script>
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
	<form method="post" action="LoanLogDal?method=add">
	<div class="content">
			<table class="box">
				
				<tr>
					<td class="field">会员ID：</td>
					<td><input type="text" name="userId" class="text"   onblur="isInteger(this.value,'userId')"/><span id="userId"></span></td>
				</tr>
				<tr>
					<td class="field">图书编号：</td>
					<td><input type="text" name="isbn" class="text" onblur="isInteger(this.value,'isbn')"/><span id="isbn"></span></td>
				</tr>
				<tr>
					<td class="field">状态：</td>
					<td><input type="text" name="condition" class="text" value="已借出" onblur="checkuser(this,'condition')"/><span id="condition"></span></td>
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
