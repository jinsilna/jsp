<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% UserVo userVo = (UserVo)session.getAttribute("userVo"); %>
	 main.jsp<%=userVo.getName()+ "[" + userVo.getAlias() + "] 님 안녕하세요."%><br>
	 
	<!--  LoginServlet.java 에서 값이 일치할 경우 넘겨주는곳.  -->
	 <br>
	 userId : <%=request.getParameter("userId")%><br>
	 <br>
	 password : <%=request.getParameter("password")%><br>
	    
</body>
</html>