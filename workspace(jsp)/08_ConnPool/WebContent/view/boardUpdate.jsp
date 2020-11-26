<%@page import="com.conn.model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDTO post = (BoardDTO)request.getAttribute("edit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "green">
			<h2>게시물 수정 페이지</h2>
		<hr width = "50%" color = "green">
		<br><br><br>
		<form method = "post" action = "<%=request.getContextPath() %>/updateOk">
		<input type = "hidden" name = "num" value = "<%=post.getNum() %>">
		<table border = "1" cellspacing = "0" width = "400">
			<tr>
				<th>글제목</th>
				<td><input type = "text" value = "<%=post.getTitle() %>" name = "title"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type = "text" value="<%=post.getWriter() %>" name = "writer"></td>
			</tr>
			<tr>
				<th>글내용</th>
				<td>
					<textarea rows="13" cols="35" name = "cont"><%=post.getCont() %></textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type = "password" name = "pwd"></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=post.getHit() %>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=post.getRegdate() %>
			</tr>
			<tr>
				<td colspan = "2" align = "center">
					<input type = "submit" value = "수정">
					<input type = "reset" value = "취소">
				</td>
			</tr>	
		</table>
		</form>
	</div>
</body>
</html>