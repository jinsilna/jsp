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

<!-- jquery ui css -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<title>userDetail.jsp</title>
<%-- basiclb --%>
<%@include file="/common/basiclb.jsp"%>
<%UserVo uservo = (UserVo) request.getAttribute("userVo");%>
</head>
<body>
	<!-- Daum 우편번호 서비스  주소 검색 버튼 클릭이벤트가 발생했을때 실행 -->
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

	<!-- jquery.com ui api -->
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script>
		$(document).ready(function() {
			// 생일 input datepiker 적용 

			// 개발 과정에서 사용한 기본 값 설정
			/*  $("#userId").val("sally");
			$("#name").val("샐리");
			$("#addr1").val("대전서구괴정동");
			$("#addr2").val("경성스포츠 ");
			$("#zip").val("33333");
			$("#birth").val("1888-08-08");
			$("#tel").val("01011111111");
			$("#email").val("skwlstlf@gmail.com");
			$("#pass").val("gg");
			 */

			$("#birth").datepicker({
				yearRange : "1997:2018",
				dateFormat : "yy-mm-dd",
				changeMonth : true,
				changeYear : true

			});

			$("#addrSearch").click(function() {
				new daum.Postcode({
					oncomplete : function(data) {
						// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
						// 예제를 참고하여 다양한 활용법을 확인해 보세요.

						console.log(data);
						// 주소 : roadAddress
						// 상세주소 : 빈공간 ""
						// 우편번호 : zonecode

						// 주소 input value 설정 : data.roadAddress
						// 우편번호 input value 설정 : data.zonecode

						$("#zip").val(data.zonecode);
						$("#addr1").val(data.roadAddress);
					}
				}).open();
			});
		});
	</script>
	<%-- header --%>
	<%@include file="/common/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<%-- left --%>
			<%@include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form class="form-horizontal" role="form" action="/userForm" enctype="multipart/form-data" 
					method="post">

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<input type = "file" name = "profile"/>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" name="userId"
								placeholder="사용자 아이디 ">
						</div>
					</div>


					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자
							비밀번호</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" id="pass" name="pass"
								placeholder="패스워드">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이름</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="이름">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr1" name="addr1"
								readonly="readonly" placeholder="주소">
							<!-- 주소 검색 버튼  -->
							<button type="button" id="addrSearch" class="btn btn-default">주소검색</button>
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="addr2" name="addr2"
								placeholder="상세주소">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="zip" name="zip"
								readonly="readonly" placeholder="우편번호">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">생년월일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="birth" name="birth"
								placeholder="생년월일">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">이메일</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="이메일">
						</div>
					</div>

					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">연락처</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="tel" name="tel"
								placeholder="연락처">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">사용자 등록</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
