package cn.jenkins_chen.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import cn.jenkins_chen.beans.Msg;
import cn.jenkins_chen.beans.User;
import cn.jenkins_chen.config.DBConfig;
import cn.jenkins_chen.utils.AlertUtil;

public class DB {
	
	public static User[] getUsers()
	{
		User[] users = null;
		try {
	        Class.forName("org.gjt.mm.mysql.Driver");
	    } catch (ClassNotFoundException ce) {
	        System.out.println(ce);
	    }
	    try {
	        String url = "jdbc:mysql://"+DBConfig.DB_SERVER_IP+":"+DBConfig.DB_SERVER_PORT+"/JSP?useUnicode=true&characterEncoding=utf-8";
	        System.out.println(url);
	        String dbUsername= DBConfig.COMMON_USER;
	        String pwd = DBConfig.COMMON_USER_PWD;
	        Connection con = DriverManager.getConnection(url,dbUsername,pwd);
	        Statement s = con.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_SCROLL_INSENSITIVE);
	        ResultSet rs = s.executeQuery("select * from userTable");
	        rs.last();
	        int totalNum = rs.getRow();
	        users=new User[totalNum];
	        rs.beforeFirst();
	        int i=0;
	        while (rs.next()) {
	        	int id = rs.getInt("id");
	            String username = rs.getString("username");
	            String password = rs.getString("password");
	            User user = new User();
	            user.setUserId(id);
	            user.setUsername(username);
	            user.setPassword(password);
	          	users[i++]=user;
	        }
	        rs.close();
	        s.close();
	        con.close();
	    } catch (SQLException ce) {
	        System.out.println(ce);
	    } 
	    
		return users;
	}
	
	public static ArrayList<Msg> getMsg()
	{
		ArrayList<Msg> msgs = new ArrayList<Msg>();
		
		try {
	        Class.forName("org.gjt.mm.mysql.Driver");
	    } catch (ClassNotFoundException ce) {
	        System.out.println(ce);
	    }
	    try {
	        String url = "jdbc:mysql://"+DBConfig.DB_SERVER_IP+":"+DBConfig.DB_SERVER_PORT+"/JSP?useUnicode=true&characterEncoding=utf-8";
	        System.out.println(url);
	        String dbUsername= DBConfig.COMMON_USER;
	        String pwd = DBConfig.COMMON_USER_PWD;
	        Connection con = DriverManager.getConnection(url,dbUsername,pwd);
	        Statement s = con.createStatement(ResultSet.CONCUR_READ_ONLY,ResultSet.TYPE_SCROLL_INSENSITIVE);
	        ResultSet rs = s.executeQuery("select userTable.id,username,date,title,content from userTable,lyTable where userTable.id = lyTable.userId");
	        rs.last();
	        int totalNum = rs.getRow();
	        
	        rs.beforeFirst();
	        int i=0;
	        while (rs.next()) {
	        
	        	String username = rs.getString("username");
	        	java.sql.Date date = rs.getDate("date");
	        	String title = rs.getString("title");
	        	String content = rs.getString("content");
	        	
	        	
	           Msg msg = new Msg();
	           msg.setUsername(username);
	           msg.setDate(date);
	           msg.setTitle(title);
	           msg.setContent(content);
	           msgs.add(msg);
	          	
	        }
	        rs.close();
	        s.close();
	        con.close();
	    } catch (SQLException ce) {
	        System.out.println(ce);
	    } 
		
		
		return msgs;
	}
	
	public static void addMsg(int currentUserId,String title,String content)
	{
		try {
	        Class.forName("org.gjt.mm.mysql.Driver");
	    } catch (ClassNotFoundException ce) {
	        System.out.println(ce);
	    }
	    try {
	        String url = "jdbc:mysql://"+DBConfig.DB_SERVER_IP+":"+DBConfig.DB_SERVER_PORT+"/JSP?useUnicode=true&characterEncoding=utf-8";
	        String dbUsername= DBConfig.COMMON_USER;
	        String pwd = DBConfig.COMMON_USER_PWD;
	        Connection con = DriverManager.getConnection(url,dbUsername,pwd);
	        Statement s = con.createStatement();
	        String sql = "insert into lyTable (userId,date,title,content) values("+currentUserId+",now(),\'"+title+"\',\'"+content+"\')";
	       s.execute(sql);
//	        System.out.println(sql);
	     
	        s.close();
	        con.close();
	    } catch (SQLException ce) {
	        System.out.println(ce);
	    } 
	}
	
}
