<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href = "./css/table.css">
</head>
<body>
		<div align = "center">
		<hr width = "50%" color = "orange">
			<h3>회원 삭제 폼</h3>
		<hr width = "50%" color = "orange">
		<br><br><br>
		<c:set var = "num" value = "${num }" />
		<form method = "post" action = "member_removeOk.do">
		<input type = "hidden" name = "num" value = "${num }">
		<table>
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