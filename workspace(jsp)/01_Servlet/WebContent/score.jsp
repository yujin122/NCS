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
		<form method = "post" action = "score">
		<table border = "1" cellspacing = "0">
			<tr>
				<th>이  름</th>
				<td><input type = "text" name = "name"></td>
			</tr>
			<tr>
				<th>국  어</th>
				<td><input type = "text" name = "kor"></td>
			</tr>
			<tr>
				<th>영  어</th>
				<td><input type = "text" name = "eng"></td>
			</tr>
			<tr>
				<th>수   학</th>
				<td><input type = "text" name = "mat"></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
				<input type = "submit" value = "제출">&nbsp;&nbsp;
				<input type = "reset" value = "취소">
			</tr>			
		</table>
		</form>
	</div>
</body>
</html>