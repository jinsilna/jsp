package kr.or.ddit.file.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// fileUpload.jsp 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/fileupload/fileUpload.jsp").forward(request, response);;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		/*request.getParameter("userId");
	
		일반 text 파라미터 : request.getParameter("파라미터명");
		파일 : request.getPart("파라미터명");
		request.getParameter("profile");*/
		Part profilePart = request.getPart("profile");
		System.out.println("profilePart :" + profilePart.getContentType());
		
		System.out.println( "Content-disposition : " +profilePart.getHeader("Content-disposition"));
	    //request.getReader();

     	System.out.println(request.getContentType());
		System.out.println("userId : " + request.getParameter("userId"));
		System.out.println("profile : " + request.getParameter("profile"));
		
		String contentDispositon = profilePart.getHeader("Content-disposition");
		String fileName = "";
		String[] splists = contentDispositon.split("; ");
		for(String str : splists){
			if(str.indexOf("filename=")>=0)
				//filename="brown.png"
				fileName = str.substring(10,str.lastIndexOf("\""));
	
		}
		// 파일쓰기 
		// url 정보를 실제 파일 경로로 변경
		getServletContext().getRealPath("/profile");
		profilePart.write("D:\\A_TeachingMaterial\\8.upload\\" + 
							new String(fileName.getBytes(),"UTF-8")); //파일 이름이 깨졌을때 
		profilePart.delete();  // 파일 업로드 과정에서 사용한 디스크 임시 영역을 정리 
	
	}	 
}
