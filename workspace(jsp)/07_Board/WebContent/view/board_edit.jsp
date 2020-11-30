<%@page import="com.board2.model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDTO dto = (BoardDTO)request.getAttribute("edit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
		<hr width = "50%" color = "skyblue">
			<h3>BOARD 테이블 게시물 수정 폼</h3>
		<hr width = "50%" color = "skyblue">
		<br><br><br>
		<form method = "post" action = "<%=request.getContextPath() %>/updateOk.do">
			<input type = "hidden" name = "num" value = "<%=dto.getBoard_no() %>">
			<table border = "1" cellspacing = "0" width = "400">
				<tr>
					<th>작성자</th>
					<td><input type = "text" name = "writer" value = "<%=dto.getWriter()%>" readonly></td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><input type = "text" name = "title" value = "<%=dto.getTitle()%>"></td>
				</tr>
				<tr>
					<th>글내용</th>
					<td>
						<textarea rows = "7" cols = "30" name = "content"><%=dto.getBoard_cont()%></textarea>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type = "password" name = "pwd"></td>
				</tr>
				<tr>
					<td colspan = "2" align = "center">
						<input type = "submit" value = "수정">
						&nbsp;&nbsp;&nbsp;
						<input type = "reset" value = "취소">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>