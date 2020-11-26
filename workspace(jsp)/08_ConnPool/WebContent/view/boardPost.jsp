<%@page import="com.conn.model.BoardDTO"%>
<%@page import="com.conn.model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDTO post = (BoardDTO)request.getAttribute("post");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div align = "center">
		<hr width = "50%" color = "pink">
			<h2>게시물 상세 페이지</h2>
		<hr width = "50%" color = "pink">
		<br><br><br>
		
		<table border = "1" cellspacing = "0" width = "400">
			<tr>
				<th>글제목</th>
				<td><%=post.getTitle() %></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><%=post.getWriter() %></td>
			</tr>
			<tr>
				<td colspan = "2">
					<textarea rows="15" cols="50" readonly><%=post.getCont() %></textarea>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><%
					for(int i = 0; i < post.getPwd().length(); i++){
						%>
						*
						<%
					}
				%></td>
			</tr>
			<tr>
				<th>조회수</th>
				<td><%=post.getHit() %>
			</tr>
			<tr>
				<th>작성일</th>
				<td><%=post.getRegdate() %>
			</tr>
		</table>
		<div align = "center">
			<a href = "<%=request.getContextPath() %>/updatePost?no=<%=post.getNum() %>">수정</a>
			&nbsp;&nbsp;
			<a href = "view/boardDelete.jsp?no=<%=post.getNum() %>">삭제</a>
			&nbsp;&nbsp;
			<a href = "<%=request.getContextPath() %>/boardList">전체 게시물</a>
		</div>
	</div>
</body>
</html>