package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.PageVo;

/**
 * Servlet implementation class UserServlet
 */

@WebServlet(urlPatterns={"/boradList","/boardPageList","/boardDetail"})
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//요청 URI로 로직 분기 
		String uri = request.getRequestURI();
		System.out.println("userServlet doGet : " + uri);	
		// URI == userAllList
		if(uri.equals("/boradList"))
			boradList(request, response);
		else if(uri.equals("/boardPageList"))
			boardPageList(request, response);
		else if(uri.equals("/boardDetail"))
			boardDetail(request, response);
	
	}




	private void boradList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("boradList");

		// href = 링크 클릭은 GET
		// 전체 사용자 정보조회 : parameter X 
		BoardServiceInf  boardService = new BoardService();
		List<BoardVo> boardList = boardService.BoardCnt();

		// request의 특징 : 해당 요청의 응답이 끝날때까지
		request.setAttribute("boradList", boardList);

		/* 화면으로 위임 2가지
		   1. dispatch : 보통 / 일반적으로 사용한다.
		   2. sendRedirect : 서버에 데이터가 변경되있을때 
		 */

		RequestDispatcher rd = request.getRequestDispatcher("/board/boardAllList.jsp");
		rd.forward(request, response);
		
		
	}

	// 게시판 상세조회
		@SuppressWarnings("unused")
		private void boardDetail(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			
			BoardServiceInf  boardService = new BoardService();

			// 사용자 아이디가 파라미터로 넘어옴
			String id = request.getParameter("prod_id");
			
			// 사용자 아이디에 해당하는 사용자 정보 조회
			BoardVo boardvo = boardService.selectBoard(id);
			
			System.out.println("쿼리 : " + boardvo.toString());
			// jsp로 위임하기 위해 사용자 정보를 request에 저장 
			request.setAttribute("boardvo", boardvo);
			
			// 사용자 상세 화면으로 위임 
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.jsp");
			rd.forward(request, response);

		}

		
		
		private void boardPageList(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			System.out.println("boardPageList");	

			// userservice 생성
			BoardServiceInf  boardService = new BoardService();

			// userPageList 호출: 메소드 인자 - pageVo - page, pageSize

			PageVo pagevo = new PageVo();
			pagevo.setPage(Integer.parseInt(request.getParameter("page")));
			pagevo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));

			Map<String,Object> resultMap = boardService.selectBoardPageList(pagevo);
			
			// 페이지 리스트
			List<BoardVo> boardPageList= (List<BoardVo>)resultMap.get("boardList");

			System.out.println("boardPageList : " +boardPageList.toString());

			// 페이지 건수 
			int pageCnt = (int)resultMap.get("pageCnt");

			// 단일 요청 건에는 request 객체에 저장한다.
			request.setAttribute("boardPageList", boardPageList);
			request.setAttribute("pageCnt", pageCnt);

			// forward ( userAllList.jsp --> userPagingList.jsp )
			RequestDispatcher rd = request.getRequestDispatcher("/board/boardPagingList.jsp");
			rd.forward(request, response);
		}
		
		
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
