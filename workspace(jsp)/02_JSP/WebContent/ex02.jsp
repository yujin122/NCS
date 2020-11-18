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
		<hr width = "50%" color = "orange">
			<h2>로그인</h2>
		<hr width = "50%" color = "orange">
		
		<form action = "ex02_1.jsp">
			<table border = "1" cellspacing = "0" width = "300">
				<tr>
					<th>아이디</th>
					<td><input type = "text" name = "id"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pwd"></td>
				</tr>
				<tr>
					<td colspan = "2" align = "center">
					<input type = "submit" value = "확인">
					&nbsp;&nbsp;&nbsp;
					<input type = "reset" value = "취소">
				</tr>
			</table>
		</form>
		
	</div>
	
</body>
</html>