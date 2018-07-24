<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.liangx.bean.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<font color="red"><%=session.getAttribute("succ_msg")%></font>
<body>
	<% 
		User user = (User) session.getAttribute("account");
	%>
	您好：【<%=user.getUserName() %>】 欢迎登陆我的系统
	<br/>
</body>
</html>