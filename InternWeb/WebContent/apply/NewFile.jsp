<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<input id="aa" name="aa" type="text"> 
	<input id="bb" name="bb" type="text">
	<input id="cc" name="cc" type="text">
	<form method="post" action="/rlhvote/AAA" enctype="application/json">
		<input id="hid" name="obj" type="hidden">
		<input type="submit" onclick="check()">
	</form>
	<script type="text/javascript">
		function check(){
			var aa = document.getElementById("aa");
			var bb = document.getElementById("bb");
			var cc = document.getElementById("cc");
			var hidden = document.getElementById("hid");
			
			
			var obj = {
					aa : aa.value,
					bb : bb.value,
					cc : cc.value
			};
			
			console.log(obj);
			
			//hidden.value = obj;
			
			var form = document.getElementsByTagName("form")[0];
			form.obj.value = JSON.stringify(obj);
			form.submit();
		}
	</script>
</body>
</html>