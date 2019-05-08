<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
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
	<div class="f_box" style="height: 700px; background-color: black; color: white;">
		<h1>잘못된 요청입니다.</h1>
		<h3>서버 오류일 수도 있고, 입력하신 정보가 잘못되어있을 가능성도 있기 떄문에 다시 요청해주시면 감사하겠습니다.</h3>
		<a style="background-color: white;" href="http://localhost:8080/rlhvote/apply/applicationModify">신청서 조회/수정 하기</a>
	</div>
	<myTag:Footer />
	<script src="/rlhvote/resources/script/DropdownMenu.js" type="text/javascript" charset="utf-8"></script>
</body>