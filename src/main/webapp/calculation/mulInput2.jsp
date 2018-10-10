<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mulInput2.jsp</title>
</head>
<body>
<!--  get은 값이 주소창에 출력된다. 그래서 넘겨줄때에는 post를 쓴다.  -->
<form action="/mulCalculationServlet2" method= "get"> <br>
	<input type = "text" name = "param1"> <br>
	<input type = "text" name = "param2"> <br>
	<input type = "submit" value = "전송하기"> <br>
	</form>
</body>
</html>