<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>number.jsp</title>
</head>
<body>	

	<%-- 
	<%
		request.setAttribute("number", 100000);
		request.setAttribute("numberpercent", 1);
	%> --%>

	<!-- 위의 코드를 jstl set 으로 바꾼것.  -->
	
	<c:set value="100000" var="number" scope="request"></c:set>
	<c:set value="1" var="numberpercent" scope="request"></c:set>
	
		
	<h2> 기본 로케일 </h2>
	<fmt:formatNumber value="${number}"/> <br> 
	<fmt:formatNumber value="${number}" type="currency"/> <br> 
	<fmt:formatNumber value="${number}" type="percent"/> <br> 
	<fmt:formatNumber value="${numberpercent}" type="percent"/> <br> 

	<h2> 영문 로케일 </h2>
	<fmt:setLocale value="en-us"/>
	<fmt:formatNumber value="${number}"/> <br> 
	<fmt:formatNumber value="${number}" type="currency"/> <br> 
	<fmt:formatNumber value="${number}" type="percent"/> <br> 
	<fmt:formatNumber value="${numberpercent}" type="percent"/> <br> 

	<h2> 독일 로케일 </h2>
	<fmt:setLocale value="de-de"/>
	<fmt:formatNumber value="${number}"/> <br> 
	<fmt:formatNumber value="${number}" type="currency"/> <br> 
	<fmt:formatNumber value="${number}" type="percent"/> <br> 
	<fmt:formatNumber value="${numberpercent}" type="percent"/> <br> 
	
	<fmt:setLocale value="ko"/>
	<c:set var="parseNumber" value="1,000.99"/>
	<fmt:parseNumber value="${parseNumber }"/> 
	
		
</body>
</html>



























