<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<head>
<%@include file="/common/basiclb.jsp"%>
</head>

<body>
	<%@ include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%-- left --%>
			<%@ include file="/common/left.jsp"%>

			<%
				UserVo uservo = (UserVo) request.getAttribute("userVo");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				//	if(user.getProfile()== null){
				//	user.setProfile("/profile/noimage.png");
				//}
			%>
			<%request.setCharacterEncoding("utf-8"); %>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<%--
							
								<c:if test="${code == '01'}">
									if 안쪽 
									</c:if>
							 --%>
							 
							 <c:choose>
								 <c:when test="${userVo.profile == null}">
								 	<img src = '/profile/noimage.png'/> 
								 </c:when> 
								 <c:otherwise>
								 	<%-- <img src = "${userVo.profile}"/> --%>
								 	<img src='/fileDownloadServlet?userId=${userVo.userId}'/>
								 </c:otherwise>
							 </c:choose>
							
			
							
							<%-- <img 
								src="<%=uservo.getProfile() == null ? "/profile/noimage.png"
								: uservo.getProfile()%>" /> --%>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<label class="col-sm-2 control-label">${userVo.userId }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.name }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.add1 }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.add2 }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.zip }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<label class="control-label">
							<fmt:formatDate value = "${userVo.birth}" pattern ="yyyy-MM-dd"/>
							</label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.email }</label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<label class="control-label">${userVo.tel }</label>
						</div>
					</div>
				</form>
				<form action="/userUpdateServlet" method="get">
					<div class="form-group">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="hidden" name="userId"
									value="${userVo.userId }">
								<button type="submit" class="btn btn-default">수정</button>
							</div>
						</div>
						<div class="col-sm-10"></div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>