<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>sumcalculation.jsp</title>
</head>
<body>
	start : <%=request.getParameter("start")%> <br>
	end  : <%=request.getParameter("end")%> <br>
	mulResult : <%=session.getAttribute("mulResult") %> <br>
</body>
</html>