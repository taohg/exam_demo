<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
</head>
<%
    String webpath = request.getContextPath();
System.out.println("-----login.jsp---webpath:" + webpath);
%>
<body>
<% if(session.getAttribute("succ_msg") != null){ %>
<font color="red"><%=session.getAttribute("succ_msg")%></font>
<%} %>
<% if(session.getAttribute("error_msg") != null){ %>
<font color="red"><%=session.getAttribute("error_msg")%></font>
<%} %>
<h1>我的网站欢迎你，请先登录。。。</h1>
	<form action="login" method="post">
		用户名:<input type="text" name="userName"/><br/>
		用户密码:<input type="text" name="userPass"/></br>
		<input type="submit" value="登陆"/>
	</form>
	<hr/>
	<a href="<%=webpath %>/page/register.jsp">注册</a>
	
</body>
</html>