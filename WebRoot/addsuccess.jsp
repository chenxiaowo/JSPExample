<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>login</title>
</head>
<body>
	<h2>留言成功</h2>
	<form action="mainServlet" method="Post">
	
	<%
		String username = null;
		String password = null;
		
		Cookie cookies[]=request.getCookies();
		//遍历cookie
		for(int i=0;i<cookies.length;i++){
		Cookie cookie=cookies[i];
			if(cookie.getName().equals("username"))
			{
				username = cookie.getValue();
			}
			if(cookie.getName().equals("password"))
			{
				password = cookie.getValue();
			}
		}
	
	 %>
	
		<input type="hidden" name="username" value=<%=username %>>
		<br>
		<input type="hidden" name="password" value=<%=password %>>
		<br>
		<input type="submit" value="点击返回留言板">
		
	
	</form>
</body>
</html>