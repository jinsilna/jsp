<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="tags" tagdir="/WEB-INF/tags" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>logging.jsp</title>
</head>
<body>
	<h2>code</h2>
	<tags:prod_code code="P201"></tags:prod_code>
	<tags:prod_code code="P301"></tags:prod_code>
	<tags:prod_code code="P101"></tags:prod_code>

	<h2>loggingTag</h2>
		<tags:loggingTag></tags:loggingTag>
			1 ~ 10까지 출력 하기  : <br>
			<c:forEach begin="1" end="10" var="i"> ${i}<br></c:forEach>
		<tags:loggingTag></tags:loggingTag>
	
	<h2>colorloggingTag</h2>
		<tags:colorLogging color="green"></tags:colorLogging>
			<c:forEach begin="1" end="10" var="i"> ${i}<br></c:forEach>
		<tags:colorLogging color="brown"></tags:colorLogging>
		
		
</body>
</html>