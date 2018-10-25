<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>timesTablesJstl.jsp</title>
</head>
<body>
	<h2>구구단을 출력하장 ~</h2>
	<h2>timesTablesJstl.jsp</h2>
	<table border="1">
		<c:forEach begin="1" end="9" var="j">
			<tr>
				<%-- end 부분엔 9를 넣었는데 param.number로 바꿈. --%>
				<c:forEach begin="1" end="${param.number }" var="i">
					<c:set var="gogo" value="${i }* ${j } = ${i*j}" />
					<td>${gogo }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<!-- http:localhost:8081/basic.jsp -->