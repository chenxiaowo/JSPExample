<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>留言</title>
</head>
<body>
	<h2>请填写留言</h2>
	<form action="addServlet" method="Post">
		主题：<input type="text" name="title">
		<br>
		内容：<input type="text" name="content" style="width: 200px;height: 100px;margin-top: 20px;margin-bottom: 20px">
		<br>
		<input type="hidden" name="currentId" value=<%=request.getParameter("currentUserId") %>>
		<input type="submit" value="留言">
		<input type="reset" value="重置">
		
	</form>
	
	
</body>
</html>