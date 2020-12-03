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
			<h3>BBS 테이블 게시글 답변 글 폼</h3>
		<hr width = "50%" color = "orange">
		<br><br><br>
		
		<form method = "post" action="${pageContext.request.contextPath }/bbs_reply_ok.do">
		<c:set var = "dto" value = "${dto }" />
		<input type = "hidden" value = "${dto.getBoard_no() }" name = "no">
		<input type = "hidden" value = "${dto.getBoard_group() }" name = "group">
		<input type = "hidden" value = "${dto.getBoard_step() }" name = "step">
		<input type = "hidden" value = "${dto.getBoard_indent() }" name = "indent">
		<table border = "1" cellspacing = "0" width = "400">
			<tr>
				<th>작성자</th>
				<td><input name = "name" value = "${dto.getBoard_writer() }"></td>
			</tr>
			<tr>
				<th>글제목</th>
				<td><input name = "title" value = "${dto.getBoard_title() }"></td>
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