<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content=""> 
<link rel="icon" href="../../favicon.ico">
<title>boardAllList.jsp</title>
<%-- basiclb --%>
<%@include file="/common/basiclb.jsp"%>
</head>
<body>
	<%-- header --%>
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%-- left --%>
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">boardList</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>제품아이디</th>
					<th>제품명</th>
					<th>제품그룹명</th>
					<th>제품등록일</th>
				</tr>
			<%-- 	<!-- userList loop 이용하여 출력하기  -->
			 	 <% List<BoardVo> boardList = (List<BoardVo>)request.getAttribute("boradList");%>
				
				
				 <% for(BoardVo board : boardList){ %>
				<tr>
					<td><%=board.getProd_id() %></td>
					<td><%=board.getProd_name()%></td>
					<td><%=board.getLprod_nm() %></td>
					<td><%=board.getProd_insdate() %></td>
				<%} %>
				</tr>
				 --%>
				
		 		<c:forEach items="${boradList }" var = "vo" >
				<tr>
					<td>${vo.prod_id}</td>
					<td>${vo.prod_name}</td>
					<td>${vo.lprod_nm}</td>
					<td>${vo.prod_insdate}</td>
				</tr>
				</c:forEach> 
			</table>
		</div>

		<a class="btn btn-default pull-right">제품 등록</a>

		<div class="text-center">
			<ul class="pagination">
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
			</ul>
		</div>
	</div>
</div>
			</div>
		</div>
	</div>

</body>
</html>
