<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>페이지 이동(forward)</h2>
	<form action = "ex04_1.jsp" method = "post">
		<p>아이디 : <input type = "text" name = "id"></p>
		<p>비밀번호 : <input type = "password" name = "pwd"></p>
		<input type = "submit" value = "전송">
	</form>
	<hr>
	
	<h2>페이지 이동(redirect)</h2>
	<form action = "ex06.jsp" method = "post">
		<p>아이디 : <input type = "text" name = "id"></p>
		<p>비밀번호 : <input type = "password" name = "pwd"></p>
		<input type = "submit" value = "전송">
	</form>
	
</body>
</html>