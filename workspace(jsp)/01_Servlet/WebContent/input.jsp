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
		<form method = "post" action = "input">
			<table border = "1" cellspace = "0">
				<tr>
					<th>아이디</th>
					<td><input type = "text" name = "id"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pwd"></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type = "text" name = "name"></td>
				</tr>
				<tr>
					<th>전공과목</th>
					<td><input type = "checkbox" name = "subject"
						value = "C언어">C언어&nbsp;&nbsp;
						<input type = "checkbox" name = "subject"
						value = "Java">Java&nbsp;&nbsp;
						<input type = "checkbox" name = "subject"
						value = "JSP">JSP&nbsp;&nbsp;
						<input type = "checkbox" name = "subject"
						value = "Spring">Spring&nbsp;&nbsp;
						<input type = "checkbox" name = "subject"
						value = "PHP">PHP&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td colspan = "2" align = "center">
					<input type = "submit" value = "전송">
					&nbsp;&nbsp;&nbsp;
					<input type = "reset" value = "취소">
					
				</tr>
			</table>
		</form>
	</div>
</body>	
</html>