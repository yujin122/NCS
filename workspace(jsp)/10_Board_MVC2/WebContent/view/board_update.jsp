<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<h3>BOARD 테이블 수정 폼</h3>
		<hr width = "50%" color = "orange">
		<br><br><br>
		<c:if test="${!empty post }" >
		<form method = "post" action = "updateOk.do">
		<input type = "hidden" name = "num" value = "${post.getBoard_no() }">
		<input type = "hidden" name = "pwd_ok" value = "${post.getBoard_pwd() }">
		<table>
		<c:set var="post" value = "${post }" />
			<tr>
				<th>작성자</th>
				<td><input name = "writer" value= "${post.getWriter() }"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input name = "title" value= "${post.getTitle() }"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
					<textarea rows = "7" cols = "30" name = "content">${post.getBoard_cont() }</textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name ="pwd"></td>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
					<input type = "submit" value = "수정">
					<input type = "reset" value = "취소">
				</td>
			</tr>
		</table>
		</form>
		</c:if>
	</div>
</body>
</html>