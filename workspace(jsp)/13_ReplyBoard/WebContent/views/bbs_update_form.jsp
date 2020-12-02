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
			<h3>BBS 테이블 게시물 수정 폼</h3>
		<hr width = "50%" color = "orange">
		<br><br><br>
		<c:set var = "dto" value = "${dto }" />
		<c:if test="${!empty dto }">
			<form method = "post" action = "bbs_update.do">
			<input type = "hidden" value = "${dto.getBoard_no() }" name = "no">
			<table border = "1" cellspacing = "0" width = "400">
			<tr>
				<th>작성자</th>
				<td><input value = "${dto.getBoard_writer() }" name = "writer"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input value = "${dto.getBoard_title() }" name = "title"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
				<textarea rows="7" cols="30" name = "content">${dto.getBoard_cont() }</textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pwd"></td>
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