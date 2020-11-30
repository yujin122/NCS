<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "./css/table.css">
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "tomato">
			<h3>회원 로그인 화면</h3>
		<hr width = "50%" color = "tomato">	
		<br><br><br>
		
		<form method = "post" action = "${pageContext.request.contextPath }/login_ok.do">
			<table>
				<tr>
					<th>아이디</th>
					<td><input type = "text" name = "id">
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pwd">
				</tr>
				<tr>
					<td colspan = "2">
						<input type = "submit" value = "로그인">&nbsp;
						<input type = "reset" value = "취소">&nbsp;
						<input type = "button" value = "회원가입"
							onclick = "location.href = 'join.do'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>