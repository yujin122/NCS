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
		<jsp:include page="../include/header.jsp" />
		<div class = "clear"></div>
		<br>
		<hr width = "50%" color = "gray">
			<h3>MVC-2 모델 BOARD 테이블 게시물 작성 페이지</h3>
		<hr width = "50%" color = "gray">
		<br><br>
		<form method = "post" action="${pageContext.request.contextPath }/board_write_ok.do">
		<table>
			<tr>
				<th>작성자</th>
				<td><input name = "name" value = "${name }"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input name = "title"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
				<textarea rows="7" cols="30" name = "content"></textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pwd"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit" value = "등록">
					&nbsp;&nbsp;&nbsp;
					<input type = "reset" value = "취소">
				</td>
			</tr>
		</table>
		</form>
	</div>
	
</body>
</html>