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
		<form method = "post" action = "ex09.jsp">
			<table border = "1" cellspacing = "0" width = "300">
				<tr>
					<th>아이디</th>
					<td><input type = "text" name = "id">
				</tr>
				<tr>
					<th>이름</th>
					<td><input name = "name">
				</tr>
				<tr>
					<th>나이</th>
					<td><input name = "age">
				</tr>
				<tr>
					<td colspan = "2" align = "center">
						<input type = "submit" value = "제출">
						&nbsp;&nbsp;&nbsp;
						<input type = "reset" value = "취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>