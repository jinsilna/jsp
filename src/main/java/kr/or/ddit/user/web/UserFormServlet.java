package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.StringUtill;


@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/userForm")
public class UserFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	// 사용자 등록 화면 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// userForm.jsp로 위임
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
		
	}

	// 사용자 등록 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 깨짐 방지! 
		request.setCharacterEncoding("utf-8");
		Part profilePart = request.getPart("profile");
		System.out.println("profilePart :" + profilePart.getContentType());
		
		System.out.println( "Content-disposition : " +profilePart.getHeader("Content-disposition"));
	    //request.getReader();

     	System.out.println(request.getContentType());
		System.out.println("userId : " + request.getParameter("userId"));
		System.out.println("profile : " + request.getParameter("profile"));
		
		String contentDispositon = profilePart.getHeader("Content-disposition");
	
		String fileName = StringUtill.getFileNameFormHeader(contentDispositon);
		
		// 파라미터 받아오기 
		// userId , pass, name , addr1, addr2, zip, birth, email, tel
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zip = request.getParameter("zip");
		String birth = request.getParameter("birth");
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String profile = "/profile/" + fileName;
		
		System.out.println(userId + "/" +pass + "/" +name + "/" + addr1 + "/"  + addr2 
				+ "/" + zip + "/" + birth + "/" +email+ "/"  +tel  + "/"  +profile);
		
		// 파라미터를 userVo 
		
		//request.setCharacterEncoding("utf-8");
		/*request.getParameter("userId");
	
		일반 text 파라미터 : request.getParameter("파라미터명");
		파일 : request.getPart("파라미터명");
		request.getParameter("profile");*/
	
		// 파일쓰기 
		// url 정보를 실제 파일 경로로 변경

		String path = getServletContext().getRealPath("/profile");

		profilePart.write(path + File.separator + fileName); //파일 이름이 깨졌을때 
		profilePart.delete();  // 파일 업로드 과정에서 사용한 디스크 임시 영역을 정리 
	 
		
		UserVo userVo = new UserVo();
		
		userVo.setUserId(userId);
		userVo.setPass  (pass);
		userVo.setName  (name);
		userVo.setAdd1  (addr1);
		userVo.setAdd2 (addr2);
		userVo.setZip   (zip);		
		userVo.setEmail (email);
		userVo.setTel   (tel);
		userVo.setProfile("/profile/" + fileName);
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			userVo.setBirth (sdf.parse(birth));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 사용자 등록 서비스 호출
		UserServiceInf userservice = new UserService();
		int insertCnt = userservice.insertUser(userVo);
		// 사용자 리스트로 이동 
		// (redirect : 서버 상태가 변경되므로  사용자가 새로고침을 통해 재요청시 중복 등록되는 현상을 막는다.)
	
		response.sendRedirect("/userPagingList?page=1&pageSize=10");
		
		
	}

}
