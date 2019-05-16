<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rhvote/resources/css/default.css" type="text/css">
<style>
#btnBox {
	margin-top: 80px;
	width: 50%;
	padding: 0 25%;
	display: flex;
	flex-direction: row;
	justify-content: center;
}

#modifyBtn {
	border: 1px solid #878787;
	padding: 8px;
}

#modifyBtn:hover {
	background-color: #878787;
	color: white;
}
</style>
</head>
<body>

	<myTag:Header />
	<div class="banner">
		<div id="banner_txt">
			<h1>이용신청서 작성 완료</h1>
			<h5>신청서 작성이 완료되었습니다.</h5>
		</div>
		<img width="100%" alt="no banner" src="/rhvote/resources/images/banner.png">
	</div>
	<div class="f_box" style="height: 500px;">
		<div id="btnBox">
			<a id="modifyBtn" href="http://localhost:8080/rhvote/apply/applicationModify">방금 작성하신 내용을 확인하거나 수정이 필요하신가요?</a>
		</div>
	</div>
	<myTag:Footer />
	<script src="/rhvote/resources/script/DropdownMenu.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>