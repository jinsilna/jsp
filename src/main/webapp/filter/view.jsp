<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view.jsp</title>
</head>
<body>
	view.jsp
	<%-- post 방식으로 전송  --%>
	
	userNm : ${userNm}<br>
	
	<form method="post" action = "/filterServlet">
		<input type="text" name = "userNm" value = "브라운"/><br>
		<button type="submit">전송</button>
	</form>
</body>
</html>