<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>

<% if(session.getAttribute("error_msg") != null){ %>
<font color="red"><%=session.getAttribute("error_msg")%></font>
<%} %>
<h1>欢迎您加入我们，请注册。。。</h1>
	<form action="add" method="post">
		用户名:<input type="text" name="userName"/><br/>
		用户密码:<input type="password" name="userPass"/></br>
		<input type="submit" value="确认注册"/>
	</form>
	
</body>
</html>