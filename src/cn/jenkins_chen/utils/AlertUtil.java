package cn.jenkins_chen.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class AlertUtil {

	public static void alert(HttpServletResponse resp,String info){
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta content=\"text/html; UTF-8\" http-equiv=\"content-type\">");
		out.println("<title>responce</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<script>");
	    out.println("alert('"+info+"');");
	    out.println("history.back();");
	    out.println("</script>");
		out.println("</body>");
	}
	
}
