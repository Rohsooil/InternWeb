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
		<h1>신청서 작성이 완료되었습니다.</h1>
		<a style="background-color: white;" href="http://localhost:8080/rlhvote/apply/applicationModify">방금 작성하신 내용을 확인하거나 수정이 필요하신가요?</a>
	</div>
	<myTag:Footer />
	<script src="/rlhvote/resources/script/DropdownMenu.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>