<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
<%@include file="/common/basiclb.jsp"%>
<%-- signin.css가져오기 // 위에 처럼 include로 가져올 수 없다. --%>
<link href="/css/signin.css" rel="stylesheet">
</head>
<body>
	<!-- 
	    http://localhost:8081/login/login.jsp
		로그인처리 
	 	login.jsp (사용자 아이디랑 비밀번호를 입력 )
		loginProcess.jsp 으로 요청 
	 -->
	 <%-- 브라우저 주소줄에 입력한 경우 : get
	 	  form 태그의 method 속성 : get/post
	  
	  	  GET - 값을 넘겨줄때 주소창에 아이디랑 비밀번호가 표시 
	  	  POST - 값을 넘겨줄때 주소창에 아이디랑 비밀번호가 표시안됌.
	  --%>
	   <div class="container">
           <form class="form-signin" action="/dditLogin" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="inputEmail" class="sr-only">userId</label>
        <input type="text" name="userId" class="form-control" placeholder="userId" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" name="password" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

</body>
</html>