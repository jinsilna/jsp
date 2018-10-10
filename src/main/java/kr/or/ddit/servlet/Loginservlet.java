package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Loginservlet extends HttpServlet{
	
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 한글깨지는거 방지 
			resp.setContentType("text/html; charset=utf-8");

			String[] userIdValues = req.getParameterValues("userId"); 
			
			PrintWriter pw = resp.getWriter();
			                                                                                                 
			pw.println("<!DOCTYPE html>                                                                       ");
			pw.println("<html>                                                                                ");
			pw.println("<head>                                                                                ");
			pw.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">                   ");
			pw.println("<title></title>                                                       ");
			pw.println("</head>                                                                               ");
			pw.println("<body>                                                                                ");
			pw.println("	                                                                                  ");
			pw.println("	                                                                                  ");
			for (String str : userIdValues){                                                       				
				pw.println(" userId : " + str);
				pw.println("<br>");
			}                                                          
			pw.println("userPass : " + req.getParameter("password"));
			pw.println("<br>");
			pw.println("</body>                                                                              ");
			pw.println("</html>                                                                               ");
		
	}
}
