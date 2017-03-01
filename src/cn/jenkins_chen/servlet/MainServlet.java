package cn.jenkins_chen.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jenkins_chen.beans.Msg;
import cn.jenkins_chen.beans.User;
import cn.jenkins_chen.config.DBConfig;
import cn.jenkins_chen.db.DB;
import cn.jenkins_chen.utils.AlertUtil;

public class MainServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			req.setCharacterEncoding("utf-8");  
			resp.setContentType("text/html;charset=utf-8");   
			boolean success = false;
			String inputUsername = req.getParameter("username");
			String inputPassword = req.getParameter("password");
			
			if(inputUsername.equals(""))
			{
				AlertUtil.alert(resp, "用户名不能为空。");
				return;
			}
			if(inputPassword.equals(""))
			{
				AlertUtil.alert(resp, "密码不能为空。");
				return;
			}
			
			User[] users = DB.getUsers();
			int currentUserId = 0;
			int totalNum=users.length;
			int i;
		          for(i=0;i<totalNum;i++)
		          {
		        	  String username = users[i].getUsername();
		        	  String password = users[i].getPassword();
		        	  if(inputUsername.equals(username)&&inputPassword.equals(password))
			            {
			            	success=true;
			            	currentUserId = users[i].getUserId();
			            	ArrayList<Msg> msgs = DB.getMsg();
			            	req.setAttribute("msgs", msgs);
			            	req.setAttribute("currentUserId", currentUserId);
			            	
			            	//使用cookie保存当前用户名和密码
			            	//createcookie.java
			            	//创建cookie(api)
			            	Cookie cookieUsername=new Cookie("username",username);
			            	Cookie cookiePassword= new Cookie("password",password);
			            	//设置cookie的生命周期
			            	cookieUsername.setMaxAge(3600);
			            	cookiePassword.setMaxAge(3600);
			            	 //把cookie信息写回给浏览器
			            	resp.addCookie(cookieUsername);
			            	resp.addCookie(cookiePassword);
			            	
			            	
			            	RequestDispatcher dispatcher = req.getRequestDispatcher("main.jsp");    // 使用req对象获取RequestDispatcher对象
			                dispatcher.forward(req, resp);
			            	return;
			            }
		          }
			
		    if(i>=totalNum)
		    {
		    	AlertUtil.alert(resp, "用户名或密码错误，请重新登录。");
		    	return;
		    }
		
	}
	
}
