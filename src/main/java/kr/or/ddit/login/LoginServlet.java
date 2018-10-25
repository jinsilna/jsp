package kr.or.ddit.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.or.ddit.encrypt.sha.KISA_SHA256;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;

public class LoginServlet extends HttpServlet{

	//service  --> request.getMethod() : "POST", "GET" --> doGet, doPost

	// 상수는 대문자 
	// 구별하려면  _ 언더바를 사용한다.

	//private final String USERID = "brown"; 
	//private final String PASSWORD = "pass1234";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		   1. 사용자 아이디 , 비밀번호를 request객체에서 받아온다.
		   2. DB에서 조회해온 아이디, 비밀번호를 체크한다.
		   3-1. 일치할 경우 main.jsp로 이동
		   3-2. 일치하지 않을 경우  login.jsp로 이동 

		   pom.xml에서 oracle dependecy scope 삭제 
		 */
		//1.
		String userId =  req.getParameter("userId");
		
		String password = req.getParameter("password");
		String rememberMe = req.getParameter("remember-me");
		System.out.println("remember-me : " + rememberMe);
		// remember-me 파라미터를 받아서 syso으로 출력

		// rememberMe == null : 아이디 기억 사용 안함 
		if(rememberMe == null){
			// rememberMe == null : 아이디 기억 사용 
			Cookie[] cookies = req.getCookies();
			for(Cookie cookie : cookies){
				// cookie 이름이 remember, userId 일경우 
				// maxage -1 설정하여 쿠키를 유효하지 않도록  설정하기  
				System.out.println(cookie.getName());
				if(cookie.getName().equals("remember")||
						cookie.getName().equals("userId")){
					//-1 : 브라우저 재시작시 쿠키 삭제 변경 
					// 0 ㅣ  바로 삭제 
					cookie.setMaxAge(0);
					resp.addCookie(cookie); // response에 cookie 넣어줘야 위에 maxage가 먹힘 
				}
			}
			
		}else{ 
			// response 객체에 cookie 저장 
			Cookie cookie = new Cookie("remember","Y");
			Cookie userIdCookie = new Cookie("userId", userId);
			resp.addCookie(cookie);
			resp.addCookie(userIdCookie);
			
			// cookie.setMaxAge(-1);
			// cookie.setMaxAge(60*60*24);
			
		}


		// 2. DB에서 조회한 아이디 
		// DB대신 상수로 대체했던걸 DB로 대체하기 
		// 2-1) 사용자가 전송한 userId 파라미터로 사용자 정보조회
		UserServiceInf service = new UserService();		
		// 2-2) DB에서 조회환 사용자 비밀번호가 파라미터로 전송된 비밀번호와 동일한지 비교 
		UserVo uservo  = service.selectUser(userId);
		// 2-3) session에 사용자 정보 등록 (as-is : 임의의 userVo 등록: 
		//                            to-be : DB에서 조회한 userVo) 
		/*
		 * 위에서 상수로 선언해줌.
				private final String USERID = "brown";
				private final String PASSWORD = "pass1234";
		 */
		//3-1 main.jsp로 이동 
		//userId.equals(uservo.getUserId()) && password.equals(uservo.getPass()
		// userId.equals(uservo.getUserId()) == 이것은 안써도된다 위에서 동일한지 비교했음.
			
		//****************암호화****************************************
		
		String encryptPass = KISA_SHA256.encrypt(password);
		if(uservo!= null && uservo.authPass(encryptPass)){
			// resp.sendRedirect("main.jsp");

			//1. session에 사용자 정보 설정 
			/*UserVo userVo = new UserVo();
			userVo.setUserId(userId);
			userVo.setName("브라운");
			userVo.setAlias("곰");
			userVo.setBirth(new Date());
			 */
			// 2. main.jsp 
			// body영역에 
			// 이름 [별명]

			HttpSession session = req.getSession();
			session.setAttribute("S_USER",uservo);

			/*
			    main.jsp null이 나왔을 경우 == null이 나오는이유는? 
	    	  	main.jsp 로 직접 보내준적이 없기때문에 
			 */

			// Redirect 요청을 다시 보내라 . DB상에 변경이 있을경우 사용한다. 
			// resp.sendRedirect("main.jsp?userId="+userId + "&password=" + password);  // url을 적어주면된다.

			// dispatch 방식 (문자열을 인자로 받고, 경로를 뜻하는것) : 기본 방식이라고 할 수 있다.  
			// 응답을 위임해서 보내느것. 요청은 딱 1번간다.
			RequestDispatcher rd = req.getRequestDispatcher("main.jsp");

			// 요청 정보를 다시 재사용하겠다는 의미. 
			// forward = 전달한다 라는 의미.
			rd.forward(req, resp); 


			//3-2 login.jsp로 이동 
		}else{
			resp.sendRedirect("login/login.jsp"); // 폴더 밖이라 폴더까지 적어주는것.





		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}
}







