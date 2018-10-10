<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pageContext.jsp</title>
</head>
<body>
	<%-- 내장객체 (implicit) 
		
		request, response, session, application, out, 
		pageContext
		
	--%>
	
	  out.equals(pageContext.getOut()) : <%=out.equals(pageContext.getOut())%> <br>
	  pageContext.getRequest(): <%=  request.equals(pageContext.getRequest()) %><br>
	  pageContext.getResponse(): <%=  response.equals(pageContext.getResponse())%><br>
	  pageContext.getSession(): <%=  session.equals( pageContext.getSession())%><br>
	  pageContext.getPage(): <%=  page.equals(pageContext.getPage()) %><br>
	  application.equals(pageContext.getPage()) : <%= application.equals(pageContext.getServletContext())%>
	 
</body>
</html>












