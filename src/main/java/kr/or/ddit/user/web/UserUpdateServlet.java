package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
@WebServlet("/userUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		UserServiceInf userService = new UserService();
		UserVo userVo = userService.selectUser(userId);
		
		request.setAttribute("userVo", userVo);
		
		request.getRequestDispatcher("/user/userUpdate.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		UserServiceInf service = new UserService();
		UserVo userVo = new UserVo();
		userVo.setUserId(request.getParameter("userId"));
		userVo.setPass(request.getParameter("pass"));
		userVo.setName(request.getParameter("name"));
		userVo.setAdd1(request.getParameter("add1"));
		userVo.setAdd2(request.getParameter("add2"));
		userVo.setZip(request.getParameter("zip"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			userVo.setBirth(sdf.parse(request.getParameter("birth")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		userVo.setTel(request.getParameter("tel"));
		userVo.setEmail("email");
		Part profilePart = request.getPart("profile");
		
		String contentDispostition = profilePart.getHeader("Content-disposition");
		String fileName = StringUtill.getFileNameFormHeader(contentDispostition);
		
		// filename이 없을경우 
		if(fileName.equals("")){
			UserVo user = service.selectUser(userVo.getUserId());
			userVo.setProfile(user.getProfile());
		
		// filename이 있을경우 
		// 신규값
		}else{			
			String path = getServletContext().getRealPath("/profile");			
			profilePart.write(path + File.separator + fileName );
			profilePart.delete();
			userVo.setProfile("/profile/"+fileName);
		}
		
		service.updateUser(userVo);
		
		response.sendRedirect("/userPagingList?page=1&pageSize=10");
	}

}