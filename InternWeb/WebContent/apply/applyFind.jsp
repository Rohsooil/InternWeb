<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rlhvote/resources/css/default.css" type="text/css">
<link rel="stylesheet" href="/rlhvote/resources/css/modify.css" type="text/css">
</head>
<body>
	<myTag:Header />
	<div class="banner">
		<div id="banner_txt">
			<h1>이용신청서 조회</h1>
			<h5>신청하셨던 이용신청서의 내용을 수정 또는 인쇄하시려면, 아래의 관리자 정보로 인증하시기 바랍니다.</h5>
		</div>
		<img width="100%" alt="no banner" src="/rlhvote/resources/images/banner.png">
	</div>
	<div class="f_box" style="height: 700px;">
		<div class="a_tableWrap">
			<div class="a_table">
				<div class="a_tableRow">
					<div class="a_title">이름</div>
					<div class="a_content"><input type="text" id="admin_name" name="admin_name"></div>
				</div>
				<div class="a_tableRow">
					<div class="a_title">휴대전화 번호</div>
					<div class="a_content">
						<myTag:phoneInputForm type="phone" id="admin_phone"/>
						<button id="authorizeBtn" onclick="checkVoteAdmin()">인증번호 요청</button>
					</div>
				</div>
				<div class="a_tableRow">
					<div class="a_title">인증번호 입력</div>
					<div class="a_content">
						<input type="text" id="auth_num" name="auth_num">
					</div>
				</div>
			</div>
		</div>
		<div class="btnBox">
			<button id="findBtn" onclick="findRegisteredVote()">조회하기</button>
		</div>
		<div class="appliedVoteWrap">
			<div id="v_table">
				<div class="v_tableRow" style="font-weight: bold;">
					<div class="v_title">투표 제목</div>
					<div class="v_length">투표 기간</div>
					<div class="v_applyDay">지원 날짜</div>
					<div class="v_function">기능</div>
				</div>
			</div>
		</div>
	</div>
	<myTag:Footer />
	<script src="/rlhvote/resources/script/module/require.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/Validate.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/DropdownMenu.js" type="text/javascript" charset="utf-8"></script>
	<script src="/rlhvote/resources/script/VoteInformGetter.js" type="text/javascript"></script>
	<script src="/rlhvote/resources/script/LookUpApplied.js" type="text/javascript"></script>
</body>
</html>