package cn.jenkins_chen.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.jenkins_chen.db.DB;
import cn.jenkins_chen.utils.AlertUtil;

public class AddServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");  
		resp.setContentType("text/html;charset=utf-8");   
		int currentUserId = Integer.parseInt(req.getParameter("currentId"));
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		DB.addMsg(currentUserId, title, content);
		
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("addsuccess.jsp");    // 使用req对象获取RequestDispatcher对象
        dispatcher.forward(req, resp);
	}
}
