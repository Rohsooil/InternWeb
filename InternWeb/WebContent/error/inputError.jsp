<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/rlhvote/resources/css/default.css" type="text/css">
<style>
#btnBox {
	margin-top: 80px;
	width: 50%;
	padding: 0 25%;
	display: flex;
	flex-direction: row;
	justify-content: center;
}

#goApplyBtn {
	border: 1px solid #878787;
	padding: 8px;
}

#goApplyBtn:hover {
	background-color: #878787;
	color: white;
}
</style>
</head>
<body>

	<myTag:Header />
	<div class="banner">
		<div id="banner_txt">
			<h1>입력값 오류</h1>
			<h5>${requestScope.Error.getMessage()}</h5>
		</div>
		<img width="100%" alt="no banner" src="/rlhvote/resources/images/banner.png">
	</div>
	<div class="f_box" style="height: 500px;">
		<div id="btnBox">
			<a id="goApplyBtn" href="http://localhost:8080/rlhvote/apply/applyForm">투표 이용신청서를 다시 작성하시겠어요?</a>
		</div>
	</div>
	<myTag:Footer />
	<script src="/rlhvote/resources/script/DropdownMenu.js" type="text/javascript" charset="utf-8"></script>
</body>
</html>