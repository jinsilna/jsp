package kr.or.ddit.request;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

/**
 * Servlet implementation class Requestservlet
 */
@WebServlet("/requestServlet") //mapping 작업 
public class Requestservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// parameter userId, name 
		// parameter : 클라이언트가 서버로 보내는 정보 
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		
		// request 정보의 값을 저장 
		UserVo userVo = getUser(userId);
		request.setAttribute("userVo",userVo); // request 객체에 저장을 한다. 
		
		HttpSession session =  request.getSession();
		session.setAttribute("userVo", userVo);

		System.out.println(userId);
		System.out.println(name);
		
		//sendRedirect : Client가 서버에 요청하면 서버가 다른 jsp/servlet으로 요청하라고 client가 안내 
		response.sendRedirect("request/requestResult.jsp?userId="+userId+"&name="+name);
		
		//dispach forward : request/ requestResult.jsp 
		/*
		RequestDispatcher rd = request.getRequestDispatcher("request/requestResult.jsp");
		rd.forward(request, response);*/
		
		//redirect
		//response.sendRedirect("request/requestResult.jsp");

		
	}
	
	public UserVo getUser(String userId){
		
		// userId 매개변수를 이용하여 사용자 정보를 DB에서 조회 
		// 아직은 DB에서 조회했다고 가정하고 ~ 
		
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setName("브라운");
		userVo.setAlias("곰");
		userVo.setBirth(new Date());
		return userVo;
	}

}
