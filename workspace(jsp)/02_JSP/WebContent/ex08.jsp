<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
	<h2>페이지 이동(forward)</h2>
	<form action = "forward" method = "post">
		<p>아이디 : <input type = "text" name = "id"></p>
		<p>비밀번호 : <input type = "password" name = "pwd"></p>
		<input type = "submit" value = "전송">
	</form>
	<hr>
	
	<h2>페이지 이동(redirect)</h2>
	<form action = "redirect" method = "post">
		<p>아이디 : <input type = "text" name = "id"></p>
		<p>비밀번호 : <input type = "password" name = "pwd"></p>
		<input type = "submit" value = "전송">
	</form>
	</div>
</body>
</html>