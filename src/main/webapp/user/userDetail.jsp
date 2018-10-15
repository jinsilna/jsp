<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
							<img
								src="<%=uservo.getProfile() == null ? "/profile/noimage.png"
					: uservo.getProfile()%>" />
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>

						<div class="col-sm-10">
							<label for="userNm" class="col-sm-2 control-label"><%=uservo.getUserId()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<label class="control-label"><%=uservo.getName()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=uservo.getAdd1()%></label>
						</div>
					</div>
					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label"><%=uservo.getAdd2()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label"><%=uservo.getZip()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<label class="control-label"><%=uservo.getBirthRomat(uservo.getBirth())%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<label class="control-label"><%=uservo.getEmail()%></label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<label class="control-label">0<%=uservo.getTel()%></label>
						</div>
					</div>
				</form>
				<form action="/userUpdateServlet" method="get">
					<div class="form-group">
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<input type="hidden" name="userId"
									value="<%=uservo.getUserId()%>">
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