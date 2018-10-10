<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mulResult2.jsp</title>
</head>
<body>
	param1 : <%= request.getParameter("param1") %> <br>
	param2 : <%= request.getParameter("param2") %>  <br>
	mulResult : <%= session.getAttribute("mulResult") %> <br>
</body>
</html>