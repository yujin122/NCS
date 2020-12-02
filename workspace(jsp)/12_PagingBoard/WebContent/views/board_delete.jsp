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
		<hr width = "50%" color = "green">
			<h3>MVC-2 모델 게시판 게시글 삭제</h3>
		<hr width = "50%" color = "green">
		<br><br>
		
		<form method = "post" action = "${pageContext.request.contextPath }/board_delete_ok.do">
		<input type = "hidden" name = "no" value = "${no }">
		<input type = "hidden" name = "page" value = "${page }">
		<table>
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pwd"></td>
			</tr>
			<tr>
				<td colspan = "2">
					<input type = "submit" value = "삭제">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>