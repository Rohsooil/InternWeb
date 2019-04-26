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
		<h1>확인사항</h1>
		<label>
			<input type="checkbox" name="step1" id="step1">
			<span>위 내용을 충분히 숙지하고 확인합니다</span>
		</label>
		<h1>개인정보</h1>
		<label>
			<input type="checkbox" name="step2" id="step2">
			<span>위 내용을 충분히 숙지하고 확인합니다</span>
		</label>
		<a id="next" href="#" style="background-color: white">다 음</a>
		<form name="next" id="next">
    		<input type="hidden" name="allChecked"/>
    	</form>
	</div>
	<myTag:Footer />
	<script src="/rlhvote/resources/script/DropdownMenu.js" type="text/javascript" charset="utf-8"></script>
	<script src="/rlhvote/resources/script/checkBoxValidate.js"	type="text/javascript" charset="utf-8"></script>
</body>
</html>