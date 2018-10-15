package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.PageVo;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet(urlPatterns={"/userAllList","/userPagingList","/userDetail"})
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//요청 URI로 로직 분기 
		String uri = request.getRequestURI();
		System.out.println("userServlet doGet : " + uri);	
		// URI == userAllList
		if(uri.equals("/userAllList"))
			userAllList(request, response);
		else if(uri.equals("/userPagingList"))
			// URI == userPageList
			userPageList(request, response);		

		// 사용자 상세 조회
		else if(uri.equals("/userDetail"))
			userDetail(request,response);
	
	}

	// 사용자 상세 조회 메소드
	private void userDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		UserServiceInf userservice = new UserService();
		// 사용자 아이디가 파라미터로 넘어옴
		String id = request.getParameter("userId");
		
		// 사용자 아이디에 해당하는 사용자 정보 조회
		UserVo uservo = userservice.selectUser(id);
				
		// jsp로 위임하기 위해 사용자 정보를 request에 저장 
		request.setAttribute("userVo", uservo);
		
		// 사용자 상세 화면으로 위임 
		RequestDispatcher rd = request.getRequestDispatcher("/user/userDetail.jsp");
		rd.forward(request, response);

	}

	/**
	 * Method : userPageList
	 * 작성자 : pc07W
	 * 변경이력 : 
	 * @param request
	 * @param response
	 * Method 설명 : 사용자 페이지 리스트 조회 
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void userPageList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("userPagingList");	

		// userservice 생성
		UserServiceInf userservice = new UserService();
		// userPageList 호출: 메소드 인자 - pageVo - page, pageSize

		PageVo pagevo = new PageVo();
		pagevo.setPage(Integer.parseInt(request.getParameter("page")));
		pagevo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));


		Map<String,Object> resultMap  = userservice.selectUserPageList(pagevo);

		// 페이지 리스트
		List<UserVo> userPageList= (List<UserVo>)resultMap.get("userList");


		// 페이지 건수 
		int pageCnt = (int)resultMap.get("pageCnt");

		// 단일 요청 건에는 request 객체에 저장한다.
		request.setAttribute("userPageList", userPageList);
		request.setAttribute("pageCnt", pageCnt);

		// forward ( userAllList.jsp --> userPagingList.jsp )
		RequestDispatcher rd = request.getRequestDispatcher("/user/userPagingList.jsp");
		rd.forward(request, response);


	}

	private void userAllList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		System.out.println("userAllList");

		// href = 링크 클릭은 GET
		// 전체 사용자 정보조회 : parameter X 
		UserServiceInf userservice = new UserService();
		List<UserVo> userList = userservice.selectUserAll();

		// 조회된 사용자 정보를 userAll.jsp를 통해 화면처리
		// userAllList.jsp에서 userList를 참조하려면? 
		// attribute 

		/*
		   session의 특징 : 해당 사용자만 접근이 가능 (사용자의 전용공간)
						  자주 참조하는 데이터 
		     너무 많은 데이터를 저장 할 경우 ? 과부화(OOM) 유발 가능성 			  

		 */

		/* application의 특징 : 모든 사용자가 접근이 가능(서버당 하나만 생성) 

		    getServletContext().setAttribute("userList", userList);
			application - 일반적으로 설정과 관련된 값을 저장 
		 */

		// request의 특징 : 해당 요청의 응답이 끝날때까지
		request.setAttribute("userList", userList);

		/* 화면으로 위임 2가지
		   1. dispatch : 보통 / 일반적으로 사용한다.
		   2. sendRedirect : 서버에 데이터가 변경되있을때 
		 */

		RequestDispatcher rd = request.getRequestDispatcher("/user/userAllList.jsp");
		rd.forward(request, response);
	}
	
	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
