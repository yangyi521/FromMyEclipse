<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>删除信息</title>
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
	function checkuser(e){
		var name1=  e.trim();
 if (name1== "")      
  {   
  document.getElementById("user1").innerHTML="<font color='red'>用户名不能为空</font>";
  //.innerHTML="<p>用户名不能为空</p>" ;    
  //document.biandan1.tijiao.disabled=true;
  }else{
	   var filter=/^\s*[.A-Za-z0-9_-]{6,20}\s*$/;   
 if (!filter.test(name1.value)) {
	
	document.getElementById("user1").innerHTML="<font color='red'>用户名填写不正确,请重新填写！</font>";
  //document.biandan1.tijiao.disabled=true;
}else{document.getElementById("user1").innerHTML=" ";
//return true;
}
	  }    
	  }  
</script>
 <body>
  <div class="menu">
	
</div>
<div class="main">
	<div class="optitle clearfix">
		<em><input type="button" name="button" value="添加数据" class="input-button" onclick="location.href='adminAdd.jsp'" /></em>
		<em><input type="button" name="button" value="修改数据" class="input-button" onclick="location.href='adminUpdate.jsp'" /></em>
		<em><input type="button" name="button" value="删除数据" class="input-button" onclick="location.href='adminRemove.jsp'" /></em>
		<em><input type="button" name="button" value="查找数据" class="input-button" onclick="location.href='adminSelect.jsp'" /></em>
		<div class="title">用户管理&gt;&gt;</div>
	</div>
	<form method="post" action="adminDal?method=remove">
	<div class="content">
			<table class="box">
			<tr>
					<td class="field">对象用户名：</td>
					<td><input type="text" name="userName" class="text" onblur="checkuser(this.value)"/><span id="user1"></span></td>
				</tr>
				
				<tr>
                <td colspan="2"><span><%if(null!=request.getAttribute("info")){
				out.write(request.getAttribute("info").toString());
			}%></span></td>
				</tr>
			</table>
		</div>
		<div class="buttons">
			<input type="submit" name="submit" value="提交" class="input-button"  id="tijiao"/>
			<input type="button" name="button" value="返回" class="input-button" onclick="history.back();" />
		</div>
	</form>
</div>
</body>
</html>
