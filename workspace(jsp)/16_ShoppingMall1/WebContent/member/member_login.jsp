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
		<hr width = "50%" color = "blue">
			<h3>회원 로그인 페이지</h3>
		<hr width = "50%" color = "blue">
		<br><br>
		<form method = "post" action = "member_login_ok.do">
			<table border = "1" cellspacing = "0" width = "350">
				<tr>
				<th>아이디</th>
				<td><input type = "text" name = "id"></td>
				</tr>
				<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pwd"></td>
				</tr>
				<tr>
					<td colspan = "2" align = "center">
						<input type = "submit" value = "로그인">
						<input type = "reset" value = "취소">
					</td>
			</table>
		</form>
	</div>
	
</body>
</html>