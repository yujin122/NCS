<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "orange">
			<h3>UPLOAD 테이블 삭제 폼</h3>
		<hr width = "50%" color = "orange">
		<br><br><br>
		<form method = "post" action = "upload_delete.do">
		<input type = "hidden" name = "no" value = "${no }">
		<table border = "1" cellspacing = "0" width = "400">
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pwd">
			</tr>
			<tr>
				<td colspan = "2" align = "center">
					<input type = "submit" value = "삭제">
					<input type = "reset" value = "취소">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>