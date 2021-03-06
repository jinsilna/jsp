package kr.or.ddit.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// session 무효화 
		// 1. session 객체를 확보 
		// 2. session invalidate 메소드를 통하여 무효화
		
		// < servlet > 
		// page        : 존재하지 않음
		// request     : 메소드 인자로 제공 
		// session     : request.getSessoin();
		// application : getServletContext(); 
		
		// < jsp >
		// page        : pageContext 내장객체
	    // request     : request     내장객체  화면에 값을 전달할때 
	    // session     : session     내장객체  로그인
		// application : application 내장객체  
		
		HttpSession session = request.getSession();
		session.invalidate(); // 무효화 
		
		
		/* 이부분 로그인 만들고 바꿔야함*/
		response.sendRedirect("/");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}





















