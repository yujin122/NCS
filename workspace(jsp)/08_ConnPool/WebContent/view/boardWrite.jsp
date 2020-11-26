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
		<h2>Board 글쓰기</h2>
	<hr width = "50%" color = "orange">
	<br><br><br>
	<form method = "post" action = "<%=request.getContextPath()%>/boardWrite">
		<table border = "1" cellspacing = "0" width = "400">
			<tr>
				<th>글제목</th>
				<td><input type = "text" name = "title" size = "30"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type = "text" name = "writer">
			</tr>
			<tr>
				<th>글내용</th>
				<td>
					<textarea rows="13" cols="35" name = "cont"></textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pwd"></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
				<input type = "submit" value = "글등록">
				</td>
		</table>
	</form>
	</div>
</body>
</html>