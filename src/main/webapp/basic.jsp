<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>basic.jsp</title>

</head>

	<% UserVo userVo = (UserVo)session.getAttribute("userVo"); %>
    main.jsp <%=userVo.getName()+ "[" + userVo.getAlias() + "] 님 안녕하세요."%><br>

	<% 
		String msg = "first jsp";
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");		
		Date date = new Date();
		String formattedDtstf = format.format(date);
	%>
<body>
	hello, world
	<br> <%=msg %> <%=formattedDtstf%>
</body>
</html>
<!-- http:localhost:8081/basic.jsp -->