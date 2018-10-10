<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>times.jsp</title>
</head>
<body>
	
	jsp 구구단 출력하기 
	
	<table border = "1">
	<%for (int i = 1; i < 10; i++) { %>
	<tr>
	<%for (int j = 1; j < 10; j++) { %>
	<td>
	<%=i%> * <%=j%> = <%=i*j%></td>
	<%}%>
	</tr>
	<%}%>
	</table>
</body>
</html>
<!-- http:localhost:8081/basic.jsp -->