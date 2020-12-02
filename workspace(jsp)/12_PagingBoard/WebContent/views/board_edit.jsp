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
	<div align= "center">
		<jsp:include page="../include/header.jsp" />
		<div class = "clear"></div>
		<br>
		<hr width = "50%" color = "green">
			<h3>MVC-2 모델 게시판 게시글 수정</h3>
		<hr width = "50%" color = "green">
		<form method = "post" action = "${pageContext.request.contextPath }/board_edit_ok.do">
		<input type = "hidden" name = "page" value = "${page }">
		<table>
			<c:set var = "dto" value = "${dto }" />
			<c:if test="${!empty dto }">
			<input type = "hidden" name = "no" value = "${dto.getBoard_no() }">
				<tr>
					<th>작성자</th>
					<td><input name = "writer" value = "${dto.getWriter() }"></td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><input name = "title" value = "${dto.getTitle() }"></td>
				</tr>
				<tr>
					<th>글내용</th>
					<td><textarea rows="7" cols="30" name = "cont">${dto.getBoard_cont() }</textarea></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pwd"></td>
				</tr>
			</c:if>
			<tr>
				<td colspan = "2" align = "center">
					<input type = "submit" value = "수정" >
					&nbsp;&nbsp;&nbsp;
					<input type = "reset" value = "취소">
				</td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>