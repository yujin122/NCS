<%@page import="com.board2.model.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDTO dto = (BoardDTO)request.getAttribute("post");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align = "center">
		<hr width = "50%" color = "yellow">
			<h3>BOARD 테이블 게시물</h3>
		<hr width = "50%" color = "yellow">
		<br><br><br>
			<table border = "1" cellspacing = "0" width = "400">
				<tr>
					<th>작성자</th>
					<td><%=dto.getWriter()%></td>
				</tr>
				<tr>
					<th>글제목</th>
					<td><%=dto.getTitle()%></td>
				</tr>
				<tr>
					<th>글내용</th>
					<td>
						<textarea rows = "7" cols = "30" name = "content" readonly><%=dto.getBoard_cont()%></textarea>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
					<%
						for(int i =0; i < dto.getBoard_pwd().length();i++){
							%>
							*
							<%
						}
					%>
					</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td><%=dto.getBoard_hit()%></td>
				</tr>
				<tr>
					<th>작성일자</th>
					<td><%=dto.getRegdate()%></td>
				</tr>
				<tr>
					<td colspan = "2" align = "center">
						<a href = "update.do?no=<%=dto.getBoard_no() %>">[수정]</a>
						<a href = "view/board_delete.jsp?no=<%=dto.getBoard_no() %>">[삭제]</a>
						<a href = "select.do">[전체게시물]</a>					
					</td>
				</tr>
			</table>
	</div>
</body>
</html>