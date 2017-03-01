<%@page import="cn.jenkins_chen.utils.AlertUtil"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="cn.jenkins_chen.beans.Msg" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>msg</title>
</head>
<body>
	
	<div style="width:45%;">
	
	<form action="addMsg.jsp" method="post">
	
	<table border="1" width="600px" align="center">
   <tr>
  	<td colspan="4" align="center" bgcolor="yellow"><h2>留言板</h2></td>
  	
  </tr>
  
  <tr>
  	<th width="100px">留言人姓名</th>
  	<th width="100px">留言时间</th>
  	<th width="100px">留言标题</th>
  	<th width="100px">留言内容</th>
  	
  </tr>
  
  <% ArrayList<Msg> msgs=(ArrayList<Msg>)request.getAttribute("msgs");  
  	 if(msgs!=null){
  		 for(int i=0;i<msgs.size();i++){  %>
  	<tr>	 
  			<td><%=msgs.get(i).getUsername() %></td>
  		  	<td><%=msgs.get(i).getDate()%></td>
  		  	<td><%=msgs.get(i).getTitle() %></td>
  		  	<td><%=msgs.get(i).getContent() %></td>
  		  	
    </tr>
   <%		 }
  	 }
  %>
  	

</table>
	<div style="float: right">
		<input type="hidden" name="currentUserId" value=<%=request.getAttribute("currentUserId") %>>
		<input type="submit" value="留言" >
	</div>
</form>
	
	</div>
	
	
	
</body>
</html>