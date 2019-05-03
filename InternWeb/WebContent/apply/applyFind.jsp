<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rlhvote/resources/css/default.css"
	type="text/css">
</head>
<body>

	<myTag:Header />
	<div class="f_box"
		style="height: 700px; background-color: black; color: white;">
		<br>
		<hr>
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" id="admin_name" name="admin_name"></td>
				</tr>
				<tr>
					<th>휴대전화 번호</th>
					<td>
						<myTag:phoneInputForm type="phone" id="admin_phone"/>
						<button onclick="checkVoteAdmin()">인증번호 요청</button>
					</td>
				</tr>	
				<tr>
					<th>인증번호 입력</th>
					<td><input type="text" id="auth_num" name="auth_num"></td>
				</tr>
			</table>
		<hr>
		<button onclick="findRegisteredVote()">조회하기</button>
		<br>
		<hr>
		<br>
		<div id="appliedVoteWrap">
			<table id="appliedVote">
				<tr>
					<th>투표 제목</th>
					<th>투표 기간</th>
					<th>지원 날짜</th>
					<th>기능</th>
				</tr>
			</table>
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